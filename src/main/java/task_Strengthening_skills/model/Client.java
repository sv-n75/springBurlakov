package task_Strengthening_skills.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import task_Strengthening_skills.dto.OrderDtoAllClient;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private Long id;

    private String title;

    @Column(name = "individual_tax_number")
    private String individualTaxNumber;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Order> orderList;

    public Client(String title, String individualTaxNumber, String phoneNumber, Address address, List<Order> orderList) {
        this.title = title;
        this.individualTaxNumber = individualTaxNumber;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orderList = orderList;
    }

}
