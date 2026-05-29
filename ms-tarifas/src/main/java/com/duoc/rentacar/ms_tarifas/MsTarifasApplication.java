package com.duoc.rentacar.ms_tarifas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsTarifasApplication {

	public static void main(String[] args) {

		SpringApplication.run(
				MsTarifasApplication.class,
				args
		);
	}
}