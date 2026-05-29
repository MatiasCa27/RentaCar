package com.duoc.rentacar.ms_tarifas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.duoc.rentacar.ms_tarifas.model.Tarifa;
import com.duoc.rentacar.ms_tarifas.service.TarifaService;

import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tarifas")
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
        return tarifa != null ? ResponseEntity.ok(tarifa) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Tarifa> guardar(
            @Valid @RequestBody Tarifa tarifa) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(tarifa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarifa> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Tarifa tarifa) {

        Tarifa actualizada = service.actualizar(id, tarifa);

        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        }

        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        service.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}