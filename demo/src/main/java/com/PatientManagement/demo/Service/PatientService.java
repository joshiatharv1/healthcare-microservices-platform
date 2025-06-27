package com.PatientManagement.demo.Service;

import com.PatientManagement.demo.Exceptions.EmailAlreadyExistsException;
import com.PatientManagement.demo.Exceptions.PatientIdNotFoundException;
import com.PatientManagement.demo.Model.Patient;
import com.PatientManagement.demo.Repository.PatientRepository;
import com.PatientManagement.demo.dto.PatientRequestDTO;
import com.PatientManagement.demo.dto.PatientResponseDTO;
import com.PatientManagement.demo.mapper.PatientMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }

    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients=patientRepository.findAll();
        List<PatientResponseDTO> patientResponseDTOS=patients.stream()
                .map(PatientMapper::toDTO).toList();
        return patientResponseDTOS;
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("A patient with this email exists" + patientRequestDTO.getEmail());
        }
        Patient newPatient= patientRepository.save(PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDTO(newPatient);
    }

    public PatientResponseDTO updatePatient(UUID id,  PatientRequestDTO patientRequestDTO){
        Patient patient=patientRepository.findById(id).orElseThrow(
                ()-> new PatientIdNotFoundException("Patient Not Found with ID"+id));
        if (patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(), id)) {
            throw new EmailAlreadyExistsException("A patient with this email already exists: " + patientRequestDTO.getEmail());
        }
        //Lets say that the persons updates the email with an email that has been taken already
        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateofbirth(LocalDate.parse(patientRequestDTO.getDateofbirth()));
//        We dont update the ID and Registered Date once created
        Patient updatedPatient=patientRepository.save(patient);
        return PatientMapper.toDTO(updatedPatient);
    }

    public void deletePatient(UUID id) {
        Patient patient=patientRepository.findById(id).orElseThrow(
                ()-> new PatientIdNotFoundException("Patient Not Found with ID"+id));
        patientRepository.deleteById(id);
    }
}
