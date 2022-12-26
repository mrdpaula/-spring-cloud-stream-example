package com.pagseguro.springcloudstreamexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.EnableMBeanExport;

@SpringBootApplication
@EnableBinding(ProcessorConfig.class)
public class SpringCloudStreamExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamExampleApplication.class, args);
	}

}
