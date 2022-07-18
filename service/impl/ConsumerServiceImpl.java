package com.example.demoKafka.service.impl;

import com.example.demoKafka.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl {
    @KafkaListener(topics = "mytopic",groupId = "group1")
    public void consume(String dataValue){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            Student student = objectMapper.readValue(dataValue,Student.class);
            System.out.println(student);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
