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
@Table(name = "marca")
@Data
public class Marca {
    @Id
    @Column(name = "id_marca")
    private Integer idMarca;
    private String nombreMarca;
}