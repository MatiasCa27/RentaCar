package com.duoc.rentacar.ms_ubicaciones.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.rentacar.ms_ubicaciones.model.Comuna;
import com.duoc.rentacar.ms_ubicaciones.repository.ComunaRepository;

@Service
public class ComunaService
{
    private static final Logger logger = LoggerFactory.getLogger(ComunaService.class);

    @Autowired
    private ComunaRepository comunaRepository;

    public List<Comuna> listarComunas()
    {
        logger.info("Consultando todas las comunas disponibles");
        return comunaRepository.findAll();
    }

    public Comuna guardar(Comuna comuna)
    {
        logger.info("Registrando nueva comuna: {}", comuna.getNombre_comuna());
        return comunaRepository.save(comuna);
    }

    public Comuna buscarPorId(Long id)
    {
        logger.info("Buscando comuna con ID: {}", id);
        return comunaRepository.findById(id).orElse(null);
    }

    public Comuna actualizar(Long id, Comuna comuna)
    {
        logger.info("Actualizando comuna con ID: {}", id);
        
        Comuna comunaExistente = comunaRepository.findById(id).orElse(null);

        if (comunaExistente != null)
        {
            comunaExistente.setNombre_comuna(comuna.getNombre_comuna());    
            comunaExistente.setRegion(comuna.getRegion());
            return comunaRepository.save(comunaExistente);
        }

        return null;
    }
}