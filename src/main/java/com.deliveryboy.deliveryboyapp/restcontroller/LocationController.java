package com.deliveryboy.deliveryboyapp.controller;

import com.deliveryboy.deliveryboyapp.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("update")
    public ResponseEntity<?> updateLocation() {
        for(int i=1;i<=10000;i++) {
            kafkaProducerService.updateLocation("( " + Math.round(Math.random() * 100) + "," + Math.round(Math.random() * 100) + " " + ")");
        }
        return new ResponseEntity<>(Collections.singletonMap("message", "location updated"), HttpStatus.OK);
    }
}
