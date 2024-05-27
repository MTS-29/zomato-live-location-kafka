package com.deliveryBoy.controller;

import com.deliveryBoy.service.KafkaService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class KafkaController {

  @Autowired
  private KafkaService kafkaService;

  @PostMapping("/update")
  public ResponseEntity<?> updateLocation(){
    for(int i=0;i<=100000;i++) {
      kafkaService.updateLocation(
          "( " + Math.round(Math.random() * 100) + " , " + Math.round(Math.random() * 100) + " )");
    }
    return new ResponseEntity<>(Map.of("message", "Location updated"), HttpStatus.OK);

  }
}
