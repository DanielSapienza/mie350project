package com.mie350project.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class BackendApplication {

	private static Logger LOG = LoggerFactory.getLogger(BackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		LOG.info("APPLICATION IS RUNNING");
	}

}
