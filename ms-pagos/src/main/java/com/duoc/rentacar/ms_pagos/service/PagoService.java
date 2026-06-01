package com.duoc.rentacar.ms_pagos.service;

import java.util.List;

import com.duoc.rentacar.ms_pagos.model.Pago;
import com.duoc.rentacar.ms_pagos.repository.PagoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoService {

    private static final Logger logger =
            LoggerFactory.getLogger(PagoService.class);

    @Autowired
    private PagoRepository pagoRepository;

    public Pago registrarPago(Pago pago) {

        if (pago == null) {

            logger.error(
                    "No se puede registrar un pago nulo"
            );

            return null;
        }

        logger.info(
                "Registrando intención de pago para renta ID: {}",
                pago.getId_renta_ref()
        );

        pago.setEstado("PENDIENTE");

        return pagoRepository.save(pago);
    }

    public List<Pago> listarPagos() {

        logger.info("Consultando listado de pagos");

        return pagoRepository.findAll();
    }

    public Pago buscarPorId(Long id) {

        logger.info("Buscando pago con ID: {}", id);

        if (id == null) {

            logger.warn(
                    "Se intentó buscar un pago con ID nulo"
            );

            return null;
        }

        return pagoRepository.findById(id).orElse(null);
    }

    public Pago actualizar(Long id, Pago pago) {

        logger.info("Actualizando pago con ID: {}", id);

        Pago pagoExistente =
                pagoRepository.findById(id).orElse(null);

        if (pagoExistente == null) {

            logger.warn(
                    "Pago no encontrado con ID: {}",
                    id
            );

            return null;
        }

        pagoExistente.setMonto(
                pago.getMonto()
        );

        pagoExistente.setEstado(
                pago.getEstado()
        );

        pagoExistente.setId_renta_ref(
                pago.getId_renta_ref()
        );

        return pagoRepository.save(pagoExistente);
    }
}