package task_Strengthening_skills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task_Strengthening_skills.converter.ClientConverter;
import task_Strengthening_skills.converter.OrderConverter;
import task_Strengthening_skills.dto.ClientDtoAll;
import task_Strengthening_skills.dto.OrderDtoAllClient;
import task_Strengthening_skills.exception.ClientException;
import task_Strengthening_skills.exception.ClientExceptionEnum;
import task_Strengthening_skills.model.Client;
import task_Strengthening_skills.model.Order;
import task_Strengthening_skills.repository.AddressRepository;
import task_Strengthening_skills.repository.ClientRepository;
import task_Strengthening_skills.repository.OrdersRepository;

import java.util.List;

@Service
public class ClientService {


    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ClientConverter clientConverter;

    @Autowired
    private OrderConverter orderConverter;

    @Autowired
    private ClientService clientService;

    public Long createClient(Client client) {
        List<Order> orderList = client.getOrderList();
        for (Order o : orderList) {
            o.setClient(client);
        }
        return clientRepository.save(client).getId();
    }

    public List<ClientDtoAll> getAll() {
        return clientConverter.converterClients(clientRepository.findAll());// возвращает все о клиентах без DTO
    }


    public ClientDtoAll getClientDtoAllById(Long id) {
        return clientConverter.converterClient(clientService.findById(id));

    }

    public String addOrder(Long id, Order order) {

        Client client = clientService.findById(id);
        client.getOrderList().add(order);
        order.setClient(client);
        clientRepository.save(client);
        return "Order is added";
    }

    public OrderDtoAllClient getOrderByIdClientAndNumberOrder(Long id, Integer number) {
        Order order = clientService.findOrderByIdClientAndNumber(id, number);
        return orderConverter.converterAllClient(order);
    }


    public String changeClientById(Long id, Client client) {//МЕНЯЕМ ТРИ ПОЛЯ
        Client c = clientService.findById(id);
        c.setIndividualTaxNumber(client.getIndividualTaxNumber());
        c.setTitle(client.getTitle());
        c.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(c);
        return "Client is changed";
    }

    public String deleteClientById(Long id) {
        Client c = clientService.findById(id);
        clientRepository.delete(c);
        return "Client is deleted";
    }

    public String changeOrder(Long id, Integer number, Order order) {//изменяем три параметра
        Order o = clientService.findOrderByIdClientAndNumber(id, number);
        o.setDateOfCreation(order.getDateOfCreation());
        o.setDescription(order.getDescription());
        o.setSum(order.getSum());
        ordersRepository.save(o);
        return "Order is changed";
    }

    public String deleteOrderByIdClientAndNumber(Long id, Integer number) {
        Client client = clientService.findById(id);
        Order order = clientService.findOrderByIdClientAndNumber(id, number);
        client.getOrderList().remove(order);
        ordersRepository.delete(order);
        return "Order is deleted";
    }

    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientException(ClientExceptionEnum.CLIENT_NOT_FOUND.getMessage()));
    }

    public Order findOrderByIdClientAndNumber(Long id, Integer number) {
        Client client = clientService.findById(id);
        return client.getOrderList().stream().filter(o -> o.getNumber().equals(number)).findFirst()
                .orElseThrow(() -> new ClientException(ClientExceptionEnum.ORDER_NOT_FOUND.getMessage()));
    }
}
