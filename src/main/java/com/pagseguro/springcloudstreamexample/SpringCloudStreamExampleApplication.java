package com.pagseguro.springcloudstreamexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(ProcessorConfig.class)
public class SpringCloudStreamExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamExampleApplication.class, args);
	}

}
