package com.pagseguro.rabbitcloudstream;

import static org.springframework.messaging.support.MessageBuilder.withPayload;

import org.springframework.messaging.Message;

public class PersonVO {

  private String name;

  private Integer age;


  public PersonVO(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "PersonVO{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }

  public Message<PersonVO> toMessage() {
    return withPayload(this).build();
  }
}
