package com.duoc.rentacar.ms_mantenimiento.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Mantenimiento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mantenimiento;

    @NotBlank(message = "El motivo del mantenimiento es obligatorio")
    private String motivo;

    @NotNull(message = "La fecha de ingreso es obligatoria")
    private LocalDate fecha_ingreso;

    private LocalDate fecha_salida;

    @Min(value = 0, message = "El costo no puede ser negativo")
    private Double costo_reparacion;

    @NotBlank(message = "Debe indicar la patente del vehículo")
    private String patente_auto_ref;
}