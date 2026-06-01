package com.duoc.rentacar.ms_tarifas.repository;

import com.duoc.rentacar.ms_tarifas.model.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Long> {
    Optional<Tarifa> findByIdTipoAutoRef(Long idTipoAutoRef);
}