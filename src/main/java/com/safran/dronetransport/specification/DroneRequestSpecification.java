package com.safran.dronetransport.specification;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.safran.dronetransport.constant.ErrorMessage;
import com.safran.dronetransport.constant.Symbol;
import com.safran.dronetransport.dto.DroneRequestDTO;
import com.safran.dronetransport.entity.Drone;
import com.safran.dronetransport.entity.DroneState;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DroneRequestSpecification {

    @Value("${drone.transport.battery.percentage.min}")
    int batteryCapacity;

    public void validateCreateRequest(DroneRequestDTO requestDTO){
        if(requestDTO.getWeight() <= 0 || requestDTO.getWeight() > 500){
            throw new RuntimeException(ErrorMessage.Drone.DRONE_WEIGHT_ERROR);
        }
    }

    public Drone applyPatchToDrone(JsonPatch patch, Drone drone) {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            JsonNode patched  = patch.apply(objectMapper.convertValue(drone, JsonNode.class));
            return objectMapper.treeToValue(patched, Drone.class);
        } catch (JsonPatchException | JsonProcessingException patchException){
            throw new RuntimeException(patchException);
        }
    }

    public void checkDroneValidityForLoading(Drone drone){
        if (drone.getBatteryCapacity() < batteryCapacity)
            throw new RuntimeException(ErrorMessage.Drone.DRONE_BATTERY_LOW_ERROR+drone.getBatteryCapacity()+ Symbol.PERCENTAGE);
        if (drone.getDroneState() != DroneState.IDLE)
            throw new RuntimeException(ErrorMessage.Drone.DRONE_NOT_LOADABLE);
    }
}
