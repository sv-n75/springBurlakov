package task_11_12.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "personnew")
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

    private String passport;

    private String adress;

    private String mobile;

    public Person(String surname, String name, String patronymic, Integer year, LocalDate creationDate
            , String password, String passport, String adress, String mobile) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.year = year;
        this.creationDate = creationDate;
        this.password = password;
        this.passport = passport;
        this.adress = adress;
        this.mobile = mobile;
    }
}
