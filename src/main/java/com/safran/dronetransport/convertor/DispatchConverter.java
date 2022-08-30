package com.safran.dronetransport.convertor;

import com.safran.dronetransport.dto.DispatchLoadResponseDTO;
import com.safran.dronetransport.dto.DroneResponseDTO;
import com.safran.dronetransport.dto.MedicationDTO;
import com.safran.dronetransport.dto.MedicationLoadResponseDTO;
import com.safran.dronetransport.entity.DispatchLoad;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DispatchConverter {

    public DispatchLoadResponseDTO convertDispatchLoadToDispatchLoadResponseDTO(DispatchLoad dispatchLoad, DroneResponseDTO droneResponseDTO, List<MedicationLoadResponseDTO> medicationLoadResponseDTOS){
        DispatchLoadResponseDTO dispatchLoadResponseDTO = new DispatchLoadResponseDTO();

        dispatchLoadResponseDTO.setId(dispatchLoad.getId());
        dispatchLoadResponseDTO.setDrone(droneResponseDTO);

        dispatchLoadResponseDTO.setMedicationLoad(medicationLoadResponseDTOS);
        dispatchLoadResponseDTO.setTotalWeight(dispatchLoad.getTotalWeight());
        return dispatchLoadResponseDTO;
    }
}
