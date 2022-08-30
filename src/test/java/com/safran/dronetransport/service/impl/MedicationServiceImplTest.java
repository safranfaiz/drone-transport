package com.safran.dronetransport.service.impl;

import com.safran.dronetransport.constant.ErrorMessage;
import com.safran.dronetransport.entity.Medication;
import com.safran.dronetransport.exception.ResourceNotFoundException;
import com.safran.dronetransport.repo.MedicationRepository;
import com.safran.dronetransport.service.MedicationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class MedicationServiceImplTest {

    private static final String CODE = "CODE";

    @MockBean
    MedicationRepository medicationRepository;

    @Autowired
    MedicationService medicationService;

    @Mock
    private Medication medication, savedMedication;

    @Test
    public void createMedicationTest() {
        Mockito.when(medicationRepository.save(medication)).thenReturn(savedMedication);
        Medication createMedication = medicationService.createMedication(medication);
        Assertions.assertEquals(createMedication, savedMedication);
    }

    @Test
    public void findByMedicationCodeTest() {
        Mockito.when(medicationRepository.findByCode(CODE)).thenReturn(Optional.of(medication));
        Medication medicationByCode = medicationService.findByMedicationCode(CODE);
        Assertions.assertEquals(medicationByCode, medication);
    }

    @Test
    public void findByMedicationCodeTestError() {
        Mockito.when(medicationRepository.findByCode(CODE)).thenReturn(Optional.empty());
        ResourceNotFoundException resourceNotFoundException = Assertions.assertThrows(
                ResourceNotFoundException.class, () -> medicationService.findByMedicationCode(CODE));
        Assertions.assertEquals(resourceNotFoundException.getMessage(), ErrorMessage.Medication.MEDICATION_NOT_FOUND + CODE);
    }
}
