package task_Strengthening_skills.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task_Strengthening_skills.dto.OrderDtoAllClient;
import task_Strengthening_skills.model.Order;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderConverter {

    @Autowired
    private ClientConverter clientConverter;


    public OrderDtoAllClient converterAllClient(Order order) {
        return new OrderDtoAllClient(order.getId(), order.getNumber(), order.getDateOfCreation()
                , order.getDescription(), order.getSum(), Math.toIntExact(order.getClient().getId()));
    }

    public List<OrderDtoAllClient> converterAllClients(List<Order> orderList) {//полная лист
        return orderList.stream().map(o -> converterAllClient(o)).collect(Collectors.toList());
    }

}
