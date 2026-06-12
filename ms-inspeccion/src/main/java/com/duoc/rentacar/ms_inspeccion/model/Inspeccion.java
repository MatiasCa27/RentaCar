package com.duoc.rentacar.ms_inspeccion.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Inspeccion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inspeccion {

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