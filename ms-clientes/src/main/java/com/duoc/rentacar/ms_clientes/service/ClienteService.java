package com.duoc.rentacar.ms_clientes.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.rentacar.ms_clientes.model.Cliente;
import com.duoc.rentacar.ms_clientes.repository.ClienteRepository;

@Service
public class ClienteService {

    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        logger.info("Consultando listado de clientes");
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id_cliente) {
        logger.info("Buscando cliente con ID: {}", id_cliente);

        if (id_cliente == null) {
            logger.warn("Se intentó buscar un cliente con ID nulo");
            return null;
        }

        return clienteRepository.findById(id_cliente).orElse(null);
    }

    public Cliente guardar(Cliente cliente) {

        if (cliente == null) {
            logger.error("No se puede guardar un cliente nulo");
            return null;
        }

        logger.info("Guardando cliente: {} con RUT: {}", cliente.getNombre(), cliente.getRut());
        return clienteRepository.save(cliente);
    }

    public Cliente actualizar(Long id_cliente, Cliente clienteActualizado) {
        logger.info("Actualizando cliente con ID: {}", id_cliente);

        Cliente clienteExistente = clienteRepository.findById(id_cliente).orElse(null);

        if (clienteExistente == null) {
            logger.warn("Cliente no encontrado con ID: {}", id_cliente);
            return null;
        }

        clienteExistente.setNombre(clienteActualizado.getNombre());
        clienteExistente.setRut(clienteActualizado.getRut());
        clienteExistente.setCorreo(clienteActualizado.getCorreo());
        clienteExistente.setTelefono(clienteActualizado.getTelefono());

        return clienteRepository.save(clienteExistente);
    }

    public void eliminar(Long id_cliente) {
        
        if (id_cliente == null) {
            logger.warn("Se intentó eliminar un cliente con ID nulo");
            return;
        }

        logger.warn("Eliminando cliente con ID: {}", id_cliente);
        clienteRepository.deleteById(id_cliente);
    }
}