package com.duoc.rentacar.ms_renta.service;

import java.util.List;

import com.duoc.rentacar.ms_renta.client.AutoClient;
import com.duoc.rentacar.ms_renta.client.ClienteClient;

import com.duoc.rentacar.ms_renta.model.Renta;
import com.duoc.rentacar.ms_renta.repository.RentaRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentaService {

    private static final Logger logger =
            LoggerFactory.getLogger(RentaService.class);

    @Autowired
    private RentaRepository rentaRepository;

    @Autowired
    private AutoClient autoClient;

    @Autowired
    private ClienteClient clienteClient;

    public Renta realizarRenta(Renta renta) {

        if (renta == null) {

            logger.error(
                    "No se puede registrar una renta nula"
            );

            return null;
        }

        logger.info(
                "Iniciando proceso de renta para patente: {}",
                renta.getPatente_auto_ref()
        );

        Object auto =
                autoClient.buscarPorPatente(
                        renta.getPatente_auto_ref()
                );

        if (auto == null) {

            logger.error(
                    "Validación fallida: el auto no existe"
            );

            return null;
        }

        Object cliente =
                clienteClient.buscarPorId(
                        renta.getRut_cliente_ref()
                );

        if (cliente == null) {

            logger.error(
                    "Validación fallida: el cliente no existe"
            );

            return null;
        }

        logger.info(
                "Validaciones remotas completadas correctamente"
        );

        return rentaRepository.save(renta);
    }

    public List<Renta> listarRentas() {

        logger.info(
                "Consultando listado de rentas"
        );

        return rentaRepository.findAll();
    }

    public Renta buscarPorId(Long id) {

        logger.info(
                "Buscando renta con ID: {}",
                id
        );

        if (id == null) {

            logger.warn(
                    "Se intentó buscar una renta con ID nulo"
            );

            return null;
        }

        return rentaRepository.findById(id).orElse(null);
    }

    public Renta actualizar(Long id, Renta renta) {

        logger.info(
                "Actualizando renta con ID: {}",
                id
        );

        Renta rentaExistente =
                rentaRepository.findById(id).orElse(null);

        if (rentaExistente == null) {

            logger.warn(
                    "No existe renta con ID: {}",
                    id
            );

            return null;
        }

        rentaExistente.setFecha_inicio(
                renta.getFecha_inicio()
        );

        rentaExistente.setDias_renta(
                renta.getDias_renta()
        );

        rentaExistente.setMonto_total(
                renta.getMonto_total()
        );

        rentaExistente.setRut_cliente_ref(
                renta.getRut_cliente_ref()
        );

        rentaExistente.setPatente_auto_ref(
                renta.getPatente_auto_ref()
        );

        return rentaRepository.save(rentaExistente);
    }
}