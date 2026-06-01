package com.duoc.rentacar.ms_ubicaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.rentacar.ms_ubicaciones.model.Comuna;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna, Long> {}