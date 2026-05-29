package com.duoc.rentacar.ms_inspeccion.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.rentacar.ms_inspeccion.model.Inspeccion;
import com.duoc.rentacar.ms_inspeccion.repository.InspeccionRepository;

@Service
public class InspeccionService {

    private static final Logger logger =
            LoggerFactory.getLogger(InspeccionService.class);

    @Autowired
    private InspeccionRepository inspeccionRepository;

    public Inspeccion registrarInspeccion(
            Inspeccion inspeccion) {

        if (inspeccion == null) {

            logger.error(
                    "No se puede registrar una inspección nula"
            );

            return null;
        }

        logger.info(
                "Registrando {} para la renta ID: {}",
                inspeccion.getTipo_inspeccion(),
                inspeccion.getId_renta_ref()
        );

        inspeccion.setFecha_inspeccion(LocalDateTime.now());

        return inspeccionRepository.save(inspeccion);
    }

    public List<Inspeccion> listarInspecciones() {

        logger.info("Consultando todas las inspecciones");

        return inspeccionRepository.findAll();
    }

    public Inspeccion buscarPorId(Long id) {

        logger.info("Buscando inspección con ID: {}", id);

        if (id == null) {

            logger.warn(
                    "Se intentó buscar una inspección con ID nulo"
            );

            return null;
        }

        return inspeccionRepository.findById(id).orElse(null);
    }

    public List<Inspeccion> buscarPorRenta(Long idRenta) {

        logger.info(
                "Consultando inspecciones para la renta ID: {}",
                idRenta
        );

        return inspeccionRepository.findByIdRentaRef(idRenta);
    }

    public Inspeccion actualizar(
            Long id,
            Inspeccion inspeccion) {

        logger.info(
                "Actualizando inspección con ID: {}",
                id
        );

        Inspeccion existente =
                inspeccionRepository.findById(id).orElse(null);

        if (existente == null) {

            logger.warn(
                    "Inspección no encontrada con ID: {}",
                    id
            );

            return null;
        }

        existente.setTipo_inspeccion(
                inspeccion.getTipo_inspeccion()
        );

        existente.setKilometraje(
                inspeccion.getKilometraje()
        );

        existente.setNivel_combustible(
                inspeccion.getNivel_combustible()
        );

        existente.setObservaciones_danos(
                inspeccion.getObservaciones_danos()
        );

        existente.setId_renta_ref(
                inspeccion.getId_renta_ref()
        );

        return inspeccionRepository.save(existente);
    }
}