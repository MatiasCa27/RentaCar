package com.duoc.rentacar.ms_catalogo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MARCA")
@Data
public class Marca {
    @Id
    @Column(name = "ID_MARCA")
    private Integer idMarca;
    private String nombreMarca;
}