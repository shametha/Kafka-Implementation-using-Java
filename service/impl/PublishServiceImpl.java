package com.example.demoKafka.service.impl;

import com.example.demoKafka.entity.Student;
import com.example.demoKafka.service.PublishService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublishServiceImpl implements PublishService {
    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public void publish(Student student) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            kafkaTemplate.send("mytopic",objectMapper.writeValueAsString(student));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
