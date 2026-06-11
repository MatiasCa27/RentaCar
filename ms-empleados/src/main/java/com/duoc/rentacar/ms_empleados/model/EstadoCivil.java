package com.duoc.rentacar.ms_empleados.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "EstadoCivil")
public class EstadoCivil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_civil")
    private Long id_estado_civil;

    @NotBlank(message = "La descripcion no puede quedadar en blanco")
    @Column(name = "desc_estado_civil")
    private String desc_estado_civil;
}