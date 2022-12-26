package com.pagseguro.springcloudstreamexample;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ProcessorConfig {
    String PERSON_QUEUE = "personIn";

    String ANIMAL_QUEUE = "animalIn";

    @Input
    SubscribableChannel animalIn();

    @Input
    SubscribableChannel personIn();

    @Output("animalOut")
    MessageChannel animalOut();

    @Output("personOut")
    MessageChannel personOut();
}
