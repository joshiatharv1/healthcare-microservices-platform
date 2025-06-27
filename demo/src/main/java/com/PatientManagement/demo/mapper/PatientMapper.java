package com.PatientManagement.demo.mapper;

import com.PatientManagement.demo.Model.Patient;
import com.PatientManagement.demo.dto.PatientRequestDTO;
import com.PatientManagement.demo.dto.PatientResponseDTO;

import java.time.LocalDate;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient){
        PatientResponseDTO patientResponseDTO= new PatientResponseDTO();
        patientResponseDTO.setAddress(patient.getAddress());
        patientResponseDTO.setId(patient.getId().toString());
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setDateofbirth(patient.getDateofbirth().toString());
        return patientResponseDTO;
    }

    public static Patient toModel(PatientRequestDTO patientRequestDTO){
        Patient patient=new Patient();
        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setDateofbirth(LocalDate.parse(patientRequestDTO.getDateofbirth()));
        patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisterDate()));
        return patient;
    }
}
