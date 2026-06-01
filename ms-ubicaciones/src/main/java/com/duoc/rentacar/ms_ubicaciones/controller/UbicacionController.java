package com.duoc.rentacar.ms_ubicaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.duoc.rentacar.ms_ubicaciones.model.Comuna;
import com.duoc.rentacar.ms_ubicaciones.service.ComunaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/ubicaciones")
public class UbicacionController
{
    @Autowired
    private ComunaService service;

    @GetMapping("/comunas")
    public ResponseEntity<List<Comuna>> obtenerComunas()
        return ResponseEntity.ok(service.listarComunas());

    @PostMapping("/comunas")
    public ResponseEntity<Comuna> crearComuna(@Valid @RequestBody Comuna comuna)
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(comuna));

    @GetMapping("/comunas/{id}")
    public ResponseEntity<Comuna> obtenerComunaPorId(@PathVariable Long id)
    {
        Comuna comuna = service.buscarPorId(id);
        
        if (comuna != null)
            return ResponseEntity.ok(comuna);

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/comunas/{id}")
    public ResponseEntity<Comuna> actualizarComuna(@PathVariable Long id, @Valid @RequestBody Comuna comuna)
    {
        Comuna actualizada = service.actualizar(id, comuna);

        if (actualizada != null)
            return ResponseEntity.ok(actualizada);

        return ResponseEntity.notFound().build();
    }
}