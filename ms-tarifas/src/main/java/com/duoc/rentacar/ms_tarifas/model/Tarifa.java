package com.duoc.rentacar.ms_tarifas.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Table(name = "TARIFA")
@Data
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarifa;

    @NotBlank(message = "La descripción de la tarifa es obligatoria")
    private String descripcion;

    @DecimalMin(value = "1.0", message = "El valor debe ser mayor a 0")
    private Double valorPorDia;

    private Long idTipoAutoRef;
}