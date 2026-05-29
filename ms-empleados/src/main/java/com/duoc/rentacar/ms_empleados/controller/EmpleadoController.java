package com.duoc.rentacar.ms_empleados.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.duoc.rentacar.ms_empleados.model.Empleado;
import com.duoc.rentacar.ms_empleados.service.EmpleadoService;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<Empleado>> listarTodos() {

        return ResponseEntity.ok(
                empleadoService.obtenerTodos()
        );
    }

    @GetMapping("/{numrun_emp}")
    public ResponseEntity<Empleado> buscarPorId(
            @PathVariable Long numrun_emp) {

        Empleado empleado =
                empleadoService.buscarPorId(numrun_emp);

        if (empleado == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(empleado);
    }

    @PostMapping
    public ResponseEntity<Empleado> guardar(
            @Valid @RequestBody Empleado empleado) {

        Empleado nuevoEmpleado =
                empleadoService.registrar(empleado);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoEmpleado);
    }

    @PutMapping("/{numrun_emp}")
    public ResponseEntity<Empleado> actualizar(
            @PathVariable Long numrun_emp,
            @Valid @RequestBody Empleado empleado) {

        Empleado empleadoActualizado =
                empleadoService.actualizar(
                        numrun_emp,
                        empleado
                );

        if (empleadoActualizado == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(empleadoActualizado);
    }

    @DeleteMapping("/{numrun_emp}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long numrun_emp) {

        empleadoService.eliminar(numrun_emp);

        return ResponseEntity.noContent().build();
    }
}