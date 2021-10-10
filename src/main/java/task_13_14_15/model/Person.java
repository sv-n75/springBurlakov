package task_13_14_15.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "person_passport")
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

    public Person(String surname, String name, String patronymic, Integer year, LocalDate creationDate
            , String password,  String address, String mobile) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.year = year;
        this.creationDate = creationDate;
        this.password = password;
        this.address = address;
        this.mobile = mobile;
    }

}
