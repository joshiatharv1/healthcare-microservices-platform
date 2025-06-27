package com.PatientManagement.demo.Exceptions;

public class PatientIdNotFoundException extends RuntimeException {
    public PatientIdNotFoundException(String message) {
        super(message);
    }
}
