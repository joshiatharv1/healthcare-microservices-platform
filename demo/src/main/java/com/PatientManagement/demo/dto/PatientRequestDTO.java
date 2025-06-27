package com.PatientManagement.demo.dto;

import com.PatientManagement.demo.dto.ValidationGroup.createPatientValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.security.PrivateKey;

public class PatientRequestDTO {
    @NotBlank(message="Name is Required !")
    @Size(max = 100, message = "Name cannot exceed 100 characters!")
    private String name;

    @NotBlank(message = "Email is Required !")
    @Email(message = "Email should be valid !")
    private String email;

    @NotBlank(message = "Address is Required !")
    private String address;

    @NotBlank(message = "Date of birth is Required !")
    private String dateofbirth;

    @NotBlank(groups = createPatientValidationGroup.class, message = "Registration Date is required")
    private String registerDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }
}
