package com.duoc.rentacar.ms_mantenimiento.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "MANTENIMIENTO")
@Data
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