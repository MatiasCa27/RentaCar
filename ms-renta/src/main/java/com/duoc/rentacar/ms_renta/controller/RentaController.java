package com.duoc.rentacar.ms_renta.controller;

import com.duoc.rentacar.ms_renta.model.Renta;
import com.duoc.rentacar.ms_renta.service.RentaService;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rentas")
public class RentaController {

    @Autowired
    private RentaService rentaService;

    @PostMapping
    public ResponseEntity<Renta> realizarRenta(@Valid @RequestBody Renta renta) {
        Renta nuevaRenta = rentaService.realizarRenta(renta);

        if (nuevaRenta == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaRenta);
    }

    @GetMapping
    public ResponseEntity<List<Renta>> listar() {
        return ResponseEntity.ok(rentaService.listarRentas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Renta> buscarPorId(@PathVariable Long id) {
        Renta renta = rentaService.buscarPorId(id);

        if (renta == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(renta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Renta> actualizar(@PathVariable Long id, @Valid @RequestBody Renta renta) {
        Renta actualizada = rentaService.actualizar(id, renta);

        if (actualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizada);
    }
}