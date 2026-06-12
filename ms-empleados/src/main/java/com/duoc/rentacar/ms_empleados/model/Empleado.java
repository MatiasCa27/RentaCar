package com.duoc.rentacar.ms_empleados.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Empleado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {

    @Id
    private Long numrun_emp;

    private String dvrun_emp;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre_emp;

    private String appaterno_emp;

    private Double sueldo_base;

    @ManyToOne
    @JoinColumn(name = "id_estado_civil", nullable = false)
    private EstadoCivil estadoCivil;

    @ManyToOne
    @JoinColumn(name = "id_sucursal", nullable = false)
    private Sucursal sucursal;
}