package task_Strengthening_skills.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;
    private Integer number;
    private Date dateOfCreation;
    private String description;
    private Integer sum;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Order(Integer number, Date dateOfCreation, String description, Integer sum) {
        this.number = number;
        this.dateOfCreation = dateOfCreation;
        this.description = description;
        this.sum = sum;
    }

}


