package com.duoc.rentacar.ms_catalogo.repository;

import com.duoc.rentacar.ms_catalogo.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepository extends JpaRepository<Auto, String> { 
}

