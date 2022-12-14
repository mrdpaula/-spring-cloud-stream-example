package com.pagseguro.rabbitcloudstream;

import java.util.function.Consumer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {


  private final Log logger = LogFactory.getLog(getClass());


  @Bean
  public Consumer<PersonVO> personConsumer() {
    return s -> logger.info("Data received..." + s);
  }

  @Bean
  public Consumer<AnimalVO> animalConsumer() {
    return s -> logger.info("Data received..." + s);
  }

}
