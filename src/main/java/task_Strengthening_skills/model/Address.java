package task_Strengthening_skills.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long id;
    private Integer regionCode;
    private String districtName;
    private String nameOfTheSettlement;
    private String StreetName;
    private Integer HouseNumber;
    private Integer caseNumber;
    private Integer officeRoomNumber;

}
