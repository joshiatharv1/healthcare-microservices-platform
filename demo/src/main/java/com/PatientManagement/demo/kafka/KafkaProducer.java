package com.PatientManagement.demo.kafka;
import com.PatientManagement.demo.Model.Patient;
import org.apache.kafka.common.utils.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import patients.event.PatientEvent;

@Service
public class KafkaProducer{
    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String, byte[]> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, byte[]> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }
    //Protobuf file will describe the events we send to our Broker or kafka

    public void sendEvent(Patient patient){
        PatientEvent event = PatientEvent.newBuilder()
                .setPatientId(patient.getId().toString())
                .setName(patient.getName())
                .setEmail(patient.getEmail())
                .setEventType("PATIENT CREATED")
                .build();
        try {
            kafkaTemplate.send("patient", event.toByteArray());
            log.info("Received PatientCreated Event: patientId={}, name={}, email={}",
                    event.getPatientId(), event.getName(), event.getEmail());
        }catch (Exception e){
            log.error("Error sending the PatientCreated Event: {} ", event);
        }

    }

}