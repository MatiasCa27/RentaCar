package com.duoc.rentacar.ms_inspeccion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.rentacar.ms_inspeccion.model.Inspeccion;

@Repository
public interface InspeccionRepository extends JpaRepository<Inspeccion, Long> {
    List<Inspeccion> findByIdRentaRef(Long idRentaRef);
}