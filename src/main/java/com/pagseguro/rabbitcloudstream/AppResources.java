package com.pagseguro.rabbitcloudstream;

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
  private EmitterProcessor<Message<PersonVO>> personEmitter;

  @Autowired
  private EmitterProcessor<Message<AnimalVO>> animalEmitter;

  @PostMapping("person")
  public void person(@RequestBody PersonVO person) {
    logger.info("m=person[POST] Received Person: " + person.toString());
    personEmitter.onNext(person.toMessage());
  }

  @PostMapping("animal")
  public void animal(@RequestBody AnimalVO animal) {
    logger.info("animal[POST] Received Animal: " + animal.toString());
    animalEmitter.onNext(animal.toMessage());
  }
}
