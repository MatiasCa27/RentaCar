package com.duoc.rentacar.ms_renta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "RentaAuto")
@Data
public class Renta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_renta;

    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate fecha_inicio;

    @NotNull(message = "Los días de renta son obligatorios")
    @Min(value = 1, message = "Debe rentar al menos 1 día")
    private Integer dias_renta;

    @NotNull(message = "El monto total es obligatorio")
    @Min(value = 0, message = "El monto no puede ser negativo")
    private Double monto_total;

    @NotNull(message = "Debe existir un cliente asociado")
    private Long rut_cliente_ref;

    @NotBlank(message = "La patente es obligatoria")
    private String patente_auto_ref;
}