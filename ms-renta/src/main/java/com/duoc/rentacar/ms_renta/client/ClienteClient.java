package com.duoc.rentacar.ms_renta.client;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-clientes")
public interface ClienteClient {

    @GetMapping("/api/v2/clientes/{id}")
    Object buscarPorId(
            @PathVariable("id") Long id);
}