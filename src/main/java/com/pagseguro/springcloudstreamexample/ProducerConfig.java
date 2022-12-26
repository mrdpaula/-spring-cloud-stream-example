package com.pagseguro.springcloudstreamexample;

import java.time.LocalDate;
import java.util.function.Supplier;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import static reactor.core.publisher.EmitterProcessor.create;

@Service
public class ProducerConfig {

  @Autowired
  private ProcessorConfig processor;

  private final Log logger = LogFactory.getLog(getClass());


  public void personProducer(PersonVO personVO) {
      processor.personOut().send(personVO.toMessage());
  }

  public void animalProducer(AnimalVO animalVO) {
    processor.animalOut().send(animalVO.toMessage());
  }

}