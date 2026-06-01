package com.duoc.rentacar.ms_catalogo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AUTO")
@Data
public class Auto {

    @Id
    @NotBlank(message = "La patente no puede estar en blanco")
    @Size(min = 6, max = 6, message = "La patente debe tener 6 caracteres")
    @Column(name = "P_AUTO", length = 6)
    private String patente;

    @NotBlank(message = "El modelo es obligatorio")
    @Column(name = "MODELO_AUTO")
    private String modelo;

    @Min(value = 0, message = "El valor no puede ser negativo")
    @Column(name = "VALOR_DIARIO")
    private Double valorRentaDia;

    @ManyToOne
    @JoinColumn(name = "ID_MARCA", nullable = false)
    private Marca marca;
}