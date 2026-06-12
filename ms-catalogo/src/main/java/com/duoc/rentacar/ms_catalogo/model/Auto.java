package com.duoc.rentacar.ms_catalogo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Auto")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Auto {

    @Id
    @NotBlank(message = "La patente no puede estar en blanco")
    @Size(min = 6, max = 6, message = "La patente debe tener 6 caracteres")
    @Column(name = "p_auto", length = 6)
    private String patente;

    @NotBlank(message = "El modelo es obligatorio")
    @Column(name = "modelo_auto")
    private String modelo;

    @Min(value = 0, message = "El valor no puede ser negativo")
    @Column(name = "valor_diario")
    private Double valorRentaDia;

    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private Marca marca;
}