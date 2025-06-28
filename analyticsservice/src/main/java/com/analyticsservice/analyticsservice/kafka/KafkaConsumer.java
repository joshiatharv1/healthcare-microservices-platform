package com.analyticsservice.analyticsservice.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patients.event.PatientEvent;

@Service
public class KafkaConsumer {
    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "patient", groupId = "analytics‑group")
    public void consumeEvent(byte[] event){
        try{
            PatientEvent patientEvent=PatientEvent.parseFrom(event);
            log.info("Recieved Patient Event: [ PatientId: {}, PatientName: {}, PatientEmail: {}]",
                    patientEvent.getPatientId(),
                    patientEvent.getName(),
                    patientEvent.getEmail());
        }catch(InvalidProtocolBufferException ex){
            log.error("Error deserializing event: {}", ex.getMessage());
        }
    }
}