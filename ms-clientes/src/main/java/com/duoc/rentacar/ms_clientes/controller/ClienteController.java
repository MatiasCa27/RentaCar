package com.duoc.rentacar.ms_clientes.controller;

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

import com.duoc.rentacar.ms_clientes.model.Cliente;
import com.duoc.rentacar.ms_clientes.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos()
        return ResponseEntity.ok(clienteService.listarTodos());

    @GetMapping("/{id_cliente}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id_cliente)
    {
        Cliente cliente = clienteService.buscarPorId(id_cliente);
        if (cliente == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> guardar(@Valid @RequestBody Cliente cliente)
    {
        Cliente nuevoCliente = clienteService.guardar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }

    @PutMapping("/{id_cliente}")
    public ResponseEntity<Cliente> actualizar(@PathVariable Long id_cliente, @Valid @RequestBody Cliente cliente) {
        Cliente clienteActualizado = clienteService.actualizar(id_cliente, cliente);

        if (clienteActualizado == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(clienteActualizado);
    }

    @DeleteMapping("/{id_cliente}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id_cliente) {
        clienteService.eliminar(id_cliente);
        return ResponseEntity.noContent().build();
    }
}