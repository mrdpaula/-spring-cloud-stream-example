package com.pagseguro.springcloudstreamexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class ConsumerConfig {


  private final Logger logger = LoggerFactory.getLogger(this.getClass());


  @Bean
  public Consumer<PersonVO> personConsumer() {
    return s -> logger.info("Data received...{}", s);
  }

  @Bean
  public Consumer<AnimalVO> animalConsumer() {
    return s -> logger.info("Data received...{}", s);
  }

}
