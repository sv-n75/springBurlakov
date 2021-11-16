package task_Strengthening_skills.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task_Strengthening_skills.dto.ClientDtoAll;
import task_Strengthening_skills.model.Client;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientConverter {

    @Autowired
    private OrderConverter orderConverter;

    @Autowired
    private AddressConverter addressConverter;


    public ClientDtoAll converterClient(Client client) {//клиент без сокращений
        return new ClientDtoAll(client.getId(), client.getTitle(), client.getIndividualTaxNumber(), client.getPhoneNumber()
                , addressConverter.getAddressClient(client.getAddress())
                , orderConverter.converterAllClients(client.getOrderList()));
    }

    public List<ClientDtoAll> converterClients(List<Client> clientList) {// вся инфа о клиентах - не DTO
        return clientList.stream().map(c -> converterClient(c)).collect(Collectors.toList());

    }
}
