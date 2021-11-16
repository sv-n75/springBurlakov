package task_Strengthening_skills.converter;

import org.springframework.stereotype.Component;
import task_Strengthening_skills.dto.AddressDTO;
import task_Strengthening_skills.model.Address;
import task_Strengthening_skills.repository.AddressRepository;


@Component
public class AddressConverter {

    public AddressDTO getAddressClient(Address address) {
        return new AddressDTO(address.getId(), address.getRegionCode(), address.getDistrictName(), address.getNameOfTheSettlement()
                , address.getStreetName(), address.getHouseNumber()
                , address.getCaseNumber(), address.getOfficeRoomNumber());
    }
}
