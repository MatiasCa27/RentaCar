package com.duoc.rentacar.ms_empleados.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "EMPLEADO")
@Data
public class Empleado {
    @Id
    private Long numrun_emp; 

    private String dvrun_emp;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre_emp;

    private String appaterno_emp;

    private Double sueldo_base;

    @ManyToOne
    @JoinColumn(name = "id_estado_civil")
    private EstadoCivil estadoCivil;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;
}   