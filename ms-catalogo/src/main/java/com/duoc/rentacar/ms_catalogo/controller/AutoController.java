package com.duoc.rentacar.ms_catalogo.controller;

import java.util.List;

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

import com.duoc.rentacar.ms_catalogo.model.Auto;
import com.duoc.rentacar.ms_catalogo.service.AutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/autos")
public class AutoController {

    @Autowired
    private AutoService autoService;

    @GetMapping
    public ResponseEntity<List<Auto>> listarTodos() {

        List<Auto> lista = autoService.obtenerTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{patente}")
    public ResponseEntity<Auto> buscarPorPatente(@PathVariable String patente) {
        Auto auto = autoService.buscarPorPatente(patente);
        
        if (auto == null)
            return ResponseEntity.notFound().build();
        
        return ResponseEntity.ok(auto);
    }

    @PostMapping
    public ResponseEntity<Auto> guardar(@Valid @RequestBody Auto auto) {
        Auto nuevoAuto = autoService.guardarAuto(auto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAuto);
    }

    @PutMapping("/{patente}")
    public ResponseEntity<Auto> actualizar(@PathVariable String patente,@Valid @RequestBody Auto auto) {
        Auto autoActualizado = autoService.actualizarAuto(patente, auto);
        
        if (autoActualizado == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(autoActualizado);
    }
}