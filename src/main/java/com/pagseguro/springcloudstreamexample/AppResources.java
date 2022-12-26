package com.pagseguro.springcloudstreamexample;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.EmitterProcessor;

@RestController
public class AppResources {

  private final Log logger = LogFactory.getLog(getClass());

  @Autowired
  private ProducerConfig producer;

  @PostMapping("person")
  public void person(@RequestBody PersonVO person) {
    logger.info("m=person[POST] Received Person: " + person.toString());
    producer.personProducer(person);
  }

  @PostMapping("animal")
  public void animal(@RequestBody AnimalVO animal) {
    logger.info("animal[POST] Received Animal: " + animal.toString());
    producer.animalProducer(animal);
  }
}
