package com.pagseguro.rabbitcloudstream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class StreamProducer {

  private final Log logger = LogFactory.getLog(getClass());

  @Autowired
  private StreamBridge bridge;

  public void sendPerson(final Message<PersonVO> message) {
    logger.info("sending person " + message);
    bridge.send("personOut", message);
  }

  public void sendAnimal(final Message<AnimalVO> message) {
    logger.info("sending animal " + message);
    bridge.send("animalOut", message);
  }
}
