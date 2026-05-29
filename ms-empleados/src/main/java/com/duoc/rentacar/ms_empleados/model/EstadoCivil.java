package com.duoc.rentacar.ms_empleados.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "ESTADO_CIVIL")
@Data
public class EstadoCivil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESTADO_CIVIL")
    private Long id_estado_civil;

    @NotBlank(message = "La descripción es obligatoria")
    @Column(name = "DESC_ESTADO_CIVIL")
    private String desc_estado_civil;
}