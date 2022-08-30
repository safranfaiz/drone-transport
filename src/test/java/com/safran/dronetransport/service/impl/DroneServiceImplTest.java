package com.safran.dronetransport.service.impl;

import com.safran.dronetransport.constant.ErrorMessage;
import com.safran.dronetransport.entity.Drone;
import com.safran.dronetransport.repo.DroneRepository;
import com.safran.dronetransport.service.DroneService;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class DroneServiceImplTest {

    private static final Long SERIAL_NUMBER = 1L;

    @MockBean
    private DroneRepository droneRepository;

    @Autowired
    private DroneService droneService;

    @Mock
    private Drone drone1, drone2, drone3;

    @Test
    public void getAllDroneTest() {
        Mockito.when(droneRepository.findAll()).thenReturn(Arrays.asList(drone1,drone2,drone3));
        List<Drone> droneList = droneService.getAllDrones();
        MatcherAssert.assertThat(droneList, Matchers.containsInAnyOrder(drone1, drone2, drone3));
    }

    @Test
    public void getDroneBySerialNumberTest(){
        Mockito.when(droneRepository.findBySerialNumber(SERIAL_NUMBER)).thenReturn(Optional.of(drone1));
        Drone drone = droneService.getDroneBySerialNumber(SERIAL_NUMBER);
        Assertions.assertEquals(drone,drone1);
    }

    @Test
    public void getDroneBySerialNumberTestError(){
        Mockito.when(droneRepository.findBySerialNumber(SERIAL_NUMBER)).thenReturn(Optional.empty());
        RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class,() -> droneService.getDroneBySerialNumber(SERIAL_NUMBER));
        Assertions.assertEquals(runtimeException.getMessage(), ErrorMessage.Drone.DRONE_NOT_FOUND+SERIAL_NUMBER);
    }
}
