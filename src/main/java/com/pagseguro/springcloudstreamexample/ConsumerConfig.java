package com.pagseguro.springcloudstreamexample;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {

  private final Log logger = LogFactory.getLog(getClass());

  @StreamListener(ProcessorConfig.PERSON_QUEUE)
  public void send(PersonVO personVO) {
    logger.info("Data received..." + personVO);
  }

  @StreamListener(ProcessorConfig.ANIMAL_QUEUE)
  public void send(AnimalVO animalVO) {
    logger.info("Data received..." + animalVO);
  }

}
