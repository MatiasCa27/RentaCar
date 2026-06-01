package com.duoc.rentacar.ms_pagos.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.duoc.rentacar.ms_pagos.model.Pago;
import com.duoc.rentacar.ms_pagos.service.PagoService;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping
    public ResponseEntity<List<Pago>> listar() {

        return ResponseEntity.ok(
                pagoService.listarPagos()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> buscarPorId(
            @PathVariable Long id) {

        Pago pago = pagoService.buscarPorId(id);

        if (pago == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pago);
    }

    @PostMapping
    public ResponseEntity<Pago> registrarPago(
            @Valid @RequestBody Pago pago) {

        Pago nuevoPago =
                pagoService.registrarPago(pago);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoPago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Pago pago) {

        Pago actualizado =
                pagoService.actualizar(id, pago);

        if (actualizado == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
    }
}