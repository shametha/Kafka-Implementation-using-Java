package com.example.demoKafka.service;

import com.example.demoKafka.entity.Student;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PublishService  {
    void publish(Student student) throws JsonProcessingException;
}
