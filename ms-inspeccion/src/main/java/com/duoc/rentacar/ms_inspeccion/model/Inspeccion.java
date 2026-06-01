package com.duoc.rentacar.ms_inspeccion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "Inspeccion")
@Data

public class Inspeccion
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_inspeccion;

    @NotNull(message = "La fecha de inspeccion es obligatoria")
    private LocalDateTime fecha_inspeccion;

    @NotBlank(message = "El tipo de inspección (IN/OUT) es obligatorio")
    private String tipo_inspeccion;

    private Integer kilometraje;
    private String nivel_combustible;
    private String observaciones_danos;

    @NotNull(message = "Debe estar asociado a una renta")
    private Long id_renta_ref;
}