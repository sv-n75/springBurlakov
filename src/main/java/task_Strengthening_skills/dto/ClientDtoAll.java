package task_Strengthening_skills.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import task_Strengthening_skills.model.Address;
import task_Strengthening_skills.model.Order;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ClientDtoAll {

    private Long id;
    private String title;
    private String individualTaxNumber;
    private String phoneNumber;
    private AddressDTO address;
    private List<OrderDtoAllClient> orderList;
}
