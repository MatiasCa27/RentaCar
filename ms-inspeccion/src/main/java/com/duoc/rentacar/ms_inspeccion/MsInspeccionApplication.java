package com.duoc.rentacar.ms_inspeccion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class MsInspeccionApplication {

	public static void main(String[] args) {

		SpringApplication.run(
				MsInspeccionApplication.class,
				args
		);
	}
}
