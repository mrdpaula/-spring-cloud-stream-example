package com.pagseguro.springcloudstreamexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppResources {

  @Autowired
  private ProducerConfig producer;


  @PostMapping("person")
  public void person(@RequestBody PersonVO person) {
    producer.send(person);
  }

  @PostMapping("animal")
  public void animal(@RequestBody AnimalVO animal) {
    producer.send(animal);
  }
}
