package com.duoc.rentacar.ms_tarifas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Tarifa")
@Data
@AllArgsConstructor
@NoArgsConstructor
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