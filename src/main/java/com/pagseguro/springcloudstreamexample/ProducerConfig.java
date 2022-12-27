package com.pagseguro.springcloudstreamexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.function.Supplier;

@Service
public class ProducerConfig {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final Sinks.Many<Message<PersonVO>> personSink = Sinks.many().multicast().onBackpressureBuffer();

  private final Sinks.Many<Message<AnimalVO>> animalSink = Sinks.many().multicast().onBackpressureBuffer();

  public void send(AnimalVO animalVO) {
    logger.info("Data sent...{}", animalVO);
    animalSink.tryEmitNext(animalVO.toMessage());
  }

  public void send(PersonVO personVO) {
    logger.info("Data sent...{}", personVO);
    personSink.tryEmitNext(personVO.toMessage());
  }

  @Bean
  public Supplier<Flux<Message<PersonVO>>> personProducer() {
    return () -> personSink.asFlux();
  }

  @Bean
  public Supplier<Flux<Message<AnimalVO>>> animalProducer() {
    return () -> animalSink.asFlux();
  }
}