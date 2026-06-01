package com.duoc.rentacar.ms_inspeccion.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.duoc.rentacar.ms_inspeccion.model.Inspeccion;
import com.duoc.rentacar.ms_inspeccion.service.InspeccionService;

@RestController
@RequestMapping("/api/inspecciones")
public class InspeccionController {

    @Autowired
    private InspeccionService inspeccionService;

    @PostMapping
    public ResponseEntity<Inspeccion> crear(
            @Valid @RequestBody Inspeccion inspeccion) {

        Inspeccion nuevaInspeccion =
                inspeccionService.registrarInspeccion(inspeccion);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevaInspeccion);
    }

    @GetMapping
    public ResponseEntity<List<Inspeccion>> listar() {

        return ResponseEntity.ok(
                inspeccionService.listarInspecciones()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inspeccion> buscarPorId(
            @PathVariable Long id) {

        Inspeccion inspeccion =
                inspeccionService.buscarPorId(id);

        if (inspeccion == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(inspeccion);
    }

    @GetMapping("/renta/{idRenta}")
    public ResponseEntity<List<Inspeccion>> buscarPorRenta(
            @PathVariable Long idRenta) {

        return ResponseEntity.ok(
                inspeccionService.buscarPorRenta(idRenta)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inspeccion> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Inspeccion inspeccion) {

        Inspeccion actualizada =
                inspeccionService.actualizar(id, inspeccion);

        if (actualizada == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizada);
    }
}