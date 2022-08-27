package com.safran.dronetransport.specification;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.safran.dronetransport.dto.DroneRequestDTO;
import com.safran.dronetransport.entity.Drone;
import org.springframework.stereotype.Component;

@Component
public class DroneRequestSpecification {

    public void validateCreateRequest(DroneRequestDTO requestDTO){
        if(requestDTO.getWeight() <= 0 || requestDTO.getWeight() > 500){
            throw new RuntimeException("Your drone is over weight");
        }
    }

    public Drone applyPatchToDrone(JsonPatch patch, Drone drone) {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            JsonNode patched  = patch.apply(objectMapper.convertValue(drone, JsonNode.class));
            return objectMapper.treeToValue(patched, Drone.class);
        } catch (JsonPatchException patchException){
            throw new RuntimeException(patchException);
        } catch (JsonProcessingException processingException){
            throw new RuntimeException(processingException);
        }
    }
}
