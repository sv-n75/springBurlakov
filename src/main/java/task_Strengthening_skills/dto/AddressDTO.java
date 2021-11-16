package task_Strengthening_skills.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddressDTO {
    private Long id;
    private Integer regionCode;
    private String districtName;
    private String nameOfTheSettlement;
    private String StreetName;
    private Integer HouseNumber;
    private Integer caseNumber;
    private Integer officeRoomNumber;

}
