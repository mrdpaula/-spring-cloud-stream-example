package com.pagseguro.springcloudstreamexample;

import java.util.function.Supplier;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import static reactor.core.publisher.EmitterProcessor.create;

@Configuration
public class ProducerConfig {

  private final Log logger = LogFactory.getLog(getClass());

  @Bean
  public EmitterProcessor<Message<PersonVO>> personEmitter() {
    return create();
  }

  @Bean
  public Supplier<Flux<Message<PersonVO>>> personProducer(
      final EmitterProcessor<Message<PersonVO>> emitter) {
    return () -> emitter;
  }

  @Bean
  public EmitterProcessor<Message<AnimalVO>> animalEmitter() {
    return create();
  }

  @Bean
  public Supplier<Flux<Message<AnimalVO>>> animalProducer(
      final EmitterProcessor<Message<AnimalVO>> emitter) {
    return () -> emitter;
  }
}