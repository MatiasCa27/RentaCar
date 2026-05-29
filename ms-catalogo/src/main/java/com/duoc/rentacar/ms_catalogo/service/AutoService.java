package com.duoc.rentacar.ms_catalogo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.rentacar.ms_catalogo.model.Auto;
import com.duoc.rentacar.ms_catalogo.repository.AutoRepository;

@Service
public class AutoService {

    private static final Logger logger =
            LoggerFactory.getLogger(AutoService.class);

    @Autowired
    private AutoRepository autoRepository;

    public List<Auto> obtenerTodos() {

        logger.info("Consultando catálogo completo de vehículos");

        return autoRepository.findAll();
    }

    public Auto buscarPorPatente(String patente) {

        logger.info("Buscando vehículo con patente: {}", patente);

        if (patente == null || patente.isBlank()) {

            logger.warn("La patente ingresada es inválida");

            return null;
        }

        return autoRepository.findById(patente).orElse(null);
    }

    public Auto guardarAuto(Auto auto) {

        if (auto == null) {

            logger.error("No se puede registrar un vehículo nulo");

            return null;
        }

        logger.info(
                "Registrando vehículo patente: {}",
                auto.getPatente()
        );

        return autoRepository.save(auto);
    }

    public Auto actualizarAuto(
            String patente,
            Auto autoActualizado) {

        logger.info(
                "Actualizando vehículo con patente: {}",
                patente
        );

        Auto autoExistente =
                autoRepository.findById(patente).orElse(null);

        if (autoExistente == null) {

            logger.warn(
                    "Vehículo no encontrado con patente: {}",
                    patente
            );

            return null;
        }

        autoExistente.setModelo(autoActualizado.getModelo());

        autoExistente.setValorRentaDia(
                autoActualizado.getValorRentaDia()
        );

        autoExistente.setMarca(
                autoActualizado.getMarca()
        );

        return autoRepository.save(autoExistente);
    }
}