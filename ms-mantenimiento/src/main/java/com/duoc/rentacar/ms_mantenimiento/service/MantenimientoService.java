package com.duoc.rentacar.ms_mantenimiento.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.rentacar.ms_mantenimiento.model.Mantenimiento;
import com.duoc.rentacar.ms_mantenimiento.repository.MantenimientoRepository;

@Service
public class MantenimientoService {

    private static final Logger logger =
            LoggerFactory.getLogger(MantenimientoService.class);

    @Autowired
    private MantenimientoRepository mantenimientoRepository;

    public Mantenimiento registrarIngreso(
            Mantenimiento mantenimiento) {

        if (mantenimiento == null) {

            logger.error(
                    "No se puede registrar un mantenimiento nulo"
            );

            return null;
        }

        logger.info(
                "Ingresando vehículo patente {} a mantenimiento por: {}",
                mantenimiento.getPatente_auto_ref(),
                mantenimiento.getMotivo()
        );

        return mantenimientoRepository.save(mantenimiento);
    }

    public List<Mantenimiento> historialPorAuto(
            String patente) {

        logger.info(
                "Consultando historial técnico del auto: {}",
                patente
        );

        return mantenimientoRepository.findByPatenteAutoRef(patente);
    }

    public List<Mantenimiento> listarMantenimientos() {

        logger.info("Consultando todos los mantenimientos");

        return mantenimientoRepository.findAll();
    }

    public Mantenimiento buscarPorId(Long id) {

        logger.info(
                "Buscando mantenimiento con ID: {}",
                id
        );

        if (id == null) {

            logger.warn(
                    "Se intentó buscar un mantenimiento con ID nulo"
            );

            return null;
        }

        return mantenimientoRepository.findById(id).orElse(null);
    }

    public Mantenimiento actualizar(
            Long id,
            Mantenimiento mantenimiento) {

        logger.info(
                "Actualizando mantenimiento con ID: {}",
                id
        );

        Mantenimiento existente =
                mantenimientoRepository.findById(id).orElse(null);

        if (existente == null) {

            logger.warn(
                    "Mantenimiento no encontrado con ID: {}",
                    id
            );

            return null;
        }

        existente.setMotivo(
                mantenimiento.getMotivo()
        );

        existente.setFecha_ingreso(
                mantenimiento.getFecha_ingreso()
        );

        existente.setFecha_salida(
                mantenimiento.getFecha_salida()
        );

        existente.setCosto_reparacion(
                mantenimiento.getCosto_reparacion()
        );

        existente.setPatente_auto_ref(
                mantenimiento.getPatente_auto_ref()
        );

        return mantenimientoRepository.save(existente);
    }
}