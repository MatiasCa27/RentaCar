package com.duoc.rentacar.ms_inspeccion.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "INSPECCION")
@Data
public class Inspeccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_inspeccion;

    @NotNull(message = "La fecha de inspección es obligatoria")
    private LocalDateTime fecha_inspeccion;

    @NotBlank(message = "El tipo de inspección (IN/OUT) es obligatorio")
    private String tipo_inspeccion;

    private Integer kilometraje;
    private String nivel_combustible;
    private String observaciones_danos;

    @NotNull(message = "Debe estar asociado a una renta")
    private Long id_renta_ref;
}