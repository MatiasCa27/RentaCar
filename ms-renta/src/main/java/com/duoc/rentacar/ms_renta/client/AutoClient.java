package com.duoc.rentacar.ms_renta.client;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-catalogo")
public interface AutoClient {

    @GetMapping("/api/autos/{patente}")
    Object buscarPorPatente(
            @PathVariable("patente") String patente);
}