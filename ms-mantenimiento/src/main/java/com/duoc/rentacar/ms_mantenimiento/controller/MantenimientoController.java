package com.duoc.rentacar.ms_mantenimiento.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.duoc.rentacar.ms_mantenimiento.model.Mantenimiento;
import com.duoc.rentacar.ms_mantenimiento.service.MantenimientoService;

@RestController
@RequestMapping("/api/mantenimientos")
public class MantenimientoController {

    @Autowired
    private MantenimientoService mantenimientoService;

    @PostMapping
    public ResponseEntity<Mantenimiento> crear(
            @Valid @RequestBody Mantenimiento mantenimiento) {

        Mantenimiento nuevoMantenimiento =
                mantenimientoService.registrarIngreso(mantenimiento);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoMantenimiento);
    }

    @GetMapping("/auto/{patente}")
    public ResponseEntity<List<Mantenimiento>> historial(
            @PathVariable String patente) {

        return ResponseEntity.ok(
                mantenimientoService.historialPorAuto(patente)
        );
    }

    @GetMapping
    public ResponseEntity<List<Mantenimiento>> listar() {

        return ResponseEntity.ok(
                mantenimientoService.listarMantenimientos()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mantenimiento> buscarPorId(
            @PathVariable Long id) {

        Mantenimiento mantenimiento =
                mantenimientoService.buscarPorId(id);

        if (mantenimiento == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(mantenimiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mantenimiento> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Mantenimiento mantenimiento) {

        Mantenimiento actualizado =
                mantenimientoService.actualizar(id, mantenimiento);

        if (actualizado == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
    }
}