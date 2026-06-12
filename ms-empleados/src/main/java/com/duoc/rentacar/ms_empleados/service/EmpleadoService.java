package com.duoc.rentacar.ms_empleados.service;

import com.duoc.rentacar.ms_empleados.model.Empleado;
import com.duoc.rentacar.ms_empleados.repository.EmpleadoRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    private static final Logger logger = LoggerFactory.getLogger(EmpleadoService.class);

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> obtenerTodos() {
        logger.info("Consultando nómina completa de empleados");
        return empleadoRepository.findAll();
    }

    public Empleado buscarPorId(Long numrun_emp) {
        logger.info("Buscando empleado con RUN: {}", numrun_emp);

        if (numrun_emp == null) {
            logger.warn("Se intentó buscar un empleado con RUN nulo");
            return null;
        }

        return empleadoRepository.findById(numrun_emp).orElse(null);
    }

    public Empleado registrar(Empleado empleado) {
        if (empleado == null) {
            logger.error("No se puede registrar un empleado nulo");
            return null;
        }

        logger.info("Registrando empleado: {} con RUN: {}", empleado.getNombre_emp(), empleado.getNumrun_emp());
        return empleadoRepository.save(empleado);
    }

    public Empleado actualizar(Long numrun_emp, Empleado empleadoActualizado) {
        logger.info("Actualizando empleado con RUN: {}", numrun_emp);

        Empleado empleadoExistente = empleadoRepository.findById(numrun_emp).orElse(null);

        if (empleadoExistente == null) {
            logger.warn("Empleado no encontrado con RUN: {}", numrun_emp);
            return null;
        }

        empleadoExistente.setDvrun_emp(empleadoActualizado.getDvrun_emp());
        empleadoExistente.setNombre_emp(empleadoActualizado.getNombre_emp());
        empleadoExistente.setAppaterno_emp(empleadoActualizado.getAppaterno_emp());
        empleadoExistente.setSueldo_base(empleadoActualizado.getSueldo_base());
        empleadoExistente.setEstadoCivil(empleadoActualizado.getEstadoCivil());
        empleadoExistente.setSucursal(empleadoActualizado.getSucursal());

        return empleadoRepository.save(empleadoExistente);
    }

    public void eliminar(Long numrun_emp) {
        if (numrun_emp == null) {
            logger.warn("Se intentó eliminar un empleado con RUN nulo");
            return;
        }

        logger.warn("Eliminando empleado con RUN: {}", numrun_emp);
        empleadoRepository.deleteById(numrun_emp);
    }
}