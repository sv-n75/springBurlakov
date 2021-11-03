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
@Table(name = "passport_dep", uniqueConstraints = @UniqueConstraint(columnNames = {"series", "number"}))
public class Passport {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "passport_id")
    private Long Id;

    private String series;

    private String number;

    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;


}
