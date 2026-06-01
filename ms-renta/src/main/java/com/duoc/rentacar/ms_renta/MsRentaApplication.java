package com.duoc.rentacar.ms_renta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MsRentaApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                MsRentaApplication.class,
                args
        );
    }
}