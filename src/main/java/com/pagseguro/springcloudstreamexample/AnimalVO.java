package com.pagseguro.springcloudstreamexample;

import static org.springframework.messaging.support.MessageBuilder.withPayload;

import org.springframework.messaging.Message;

public class AnimalVO {

  private String type;

  private String shortname;

  public AnimalVO(String type, String shortname) {
    this.type = type;
    this.shortname = shortname;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getShortname() {
    return shortname;
  }

  public void setShortname(String shortname) {
    this.shortname = shortname;
  }

  @Override
  public String toString() {
    return "AnimalVO{" +
        "type='" + type + '\'' +
        ", shortname='" + shortname + '\'' +
        '}';
  }

  public Message<AnimalVO> toMessage() {
    return withPayload(this).build();
  }
}
