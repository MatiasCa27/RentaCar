package com.duoc.rentacar.ms_tarifas.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.rentacar.ms_tarifas.model.Tarifa;
import com.duoc.rentacar.ms_tarifas.repository.TarifaRepository;

@Service
public class TarifaService
{
    private static final Logger logger = LoggerFactory.getLogger(TarifaService.class);

    @Autowired
    private TarifaRepository tarifaRepository;

    public List<Tarifa> listarTarifas()
    {
        logger.info("Consultando el listado maestro de tarifas");
        return tarifaRepository.findAll();
    }

    public Tarifa obtenerPorTipoAuto(String idTipo)
    {
        logger.info("Buscando tarifa aplicada para el tipo de auto ID: {}", idTipo);

        try {
            Long idTipoLong = Long.parseLong(idTipo);
            return tarifaRepository.findByIdTipoAutoRef(idTipoLong).orElse(null);
        } catch (NumberFormatException e)
        {
            logger.error("El ID recibido no es válido");
            return null;
        }
    }

    public Tarifa guardar(Tarifa tarifa)
    {
        logger.info("Registrando nueva tarifa");
        return tarifaRepository.save(tarifa);
    }

    public Tarifa actualizar(Long id, Tarifa tarifa)
    {
        logger.info("Actualizando tarifa con ID: {}", id);

        Tarifa tarifaExistente = tarifaRepository.findById(id).orElse(null);

        if (tarifaExistente != null)
        {
            tarifaExistente.setDescripcion(tarifa.getDescripcion());
            tarifaExistente.setValorPorDia(tarifa.getValorPorDia());
            tarifaExistente.setIdTipoAutoRef(tarifa.getIdTipoAutoRef());
            return tarifaRepository.save(tarifaExistente);
        }
        return null;
    }

    public void eliminar(Long id)
    {
        logger.info("Eliminando tarifa con ID: {}", id);
        tarifaRepository.deleteById(id);
    }
}