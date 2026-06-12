package com.duoc.rentacar.ms_tarifas.controller;

import com.duoc.rentacar.ms_tarifas.model.Tarifa;
import com.duoc.rentacar.ms_tarifas.service.TarifaService;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/tarifas")
public class TarifaController {

    @Autowired
    private TarifaService service;

    @GetMapping
    public ResponseEntity<List<Tarifa>> listar() {
        return ResponseEntity.ok(service.listarTarifas());
    }

    @GetMapping("/tipo/{idTipo}")
    public ResponseEntity<Tarifa> buscar(@PathVariable String idTipo) {
        Tarifa tarifa = service.obtenerPorTipoAuto(idTipo);

        if (tarifa == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tarifa);
    }

    @PostMapping
    public ResponseEntity<Tarifa> guardar(@Valid @RequestBody Tarifa tarifa) {
        Tarifa nuevaTarifa = service.guardar(tarifa);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaTarifa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarifa> actualizar(@PathVariable Long id, @Valid @RequestBody Tarifa tarifa) {
        Tarifa actualizada = service.actualizar(id, tarifa);

        if (actualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}