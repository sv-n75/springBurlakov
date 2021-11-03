package task_16.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person_passport_department")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String surname;

    private String name;

    private String patronymic;

    private Integer year;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport personPassport;

    private String address;

    private String mobile;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Person(String surname, String name, String patronymic, Integer year
            , LocalDate creationDate, String password
            , Passport personPassport, String address, String mobile) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.year = year;
        this.creationDate = creationDate;
        this.password = password;
        this.personPassport = personPassport;
        this.address = address;
        this.mobile = mobile;
    }
}
