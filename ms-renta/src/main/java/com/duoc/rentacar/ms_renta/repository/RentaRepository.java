package com.duoc.rentacar.ms_renta.repository;

import com.duoc.rentacar.ms_renta.model.Renta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentaRepository
        extends JpaRepository<Renta, Long> {
}