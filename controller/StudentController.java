package com.example.demoKafka.controller;

import com.example.demoKafka.entity.Student;
import com.example.demoKafka.service.PublishService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/student")
@RestController
public class StudentController {
    @Autowired
    PublishService publishService;

    @PostMapping
    public void publish(@RequestBody Student student) throws JsonProcessingException {
        try{
            publishService.publish(student);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
