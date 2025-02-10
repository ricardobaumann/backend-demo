package com.getambush.backend.backend_demo;

import org.springframework.boot.SpringApplication;

public class TestBackendDemoApplication {

	public static void main(String[] args) {
		SpringApplication.from(BackendDemoApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
