package task_Strengthening_skills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task_Strengthening_skills.dto.ClientDtoAll;
import task_Strengthening_skills.dto.OrderDtoAllClient;
import task_Strengthening_skills.model.Client;
import task_Strengthening_skills.model.Order;
import task_Strengthening_skills.service.ClientService;

import java.util.List;


@RestController
@RequestMapping(path = "clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/newClient")
    public Long addClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @GetMapping("/clients")
    public List<ClientDtoAll> getAllClients() {//вся информация из таблицы
        return clientService.getAll();
    }


    @GetMapping("/id/{id}")//по клиенту с списком всех заказов
    public ClientDtoAll getClientDtoAll(@PathVariable Long id) {
        return clientService.getClientDtoAllById(id);
    }

    @GetMapping("/idNumber")// по id клиента  и номеру заказа - можно поменять на описание заказа к примеру или по сумме
    public OrderDtoAllClient getOrderByClient(@RequestParam Long id, @RequestParam Integer number) {
        return clientService.getOrderByIdClientAndNumberOrder(id, number);
    }

    @PutMapping("/id/{id}")//добавление заказа
    public String addOrder(@PathVariable Long id, @RequestBody Order order) {
        return clientService.addOrder(id, order);
    }


    @PutMapping("/change/{id}")//изменение client
    public String changeClient(@PathVariable Long id, @RequestBody Client client) {
        return clientService.changeClientById(id, client);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        return clientService.deleteClientById(id);
    }

    @PutMapping("/changeOrder/{id}")
    public String changeOrder(@PathVariable Long id, @RequestParam Integer number, @RequestBody Order order) {
        return clientService.changeOrder(id, number, order);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable Long id, @RequestParam Integer number) {
        return clientService.deleteOrderByIdClientAndNumber(id, number);
    }
}
