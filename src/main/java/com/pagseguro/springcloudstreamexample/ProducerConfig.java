package com.pagseguro.springcloudstreamexample;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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