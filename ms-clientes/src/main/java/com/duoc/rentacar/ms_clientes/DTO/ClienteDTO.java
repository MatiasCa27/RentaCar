package com.duoc.rentacar.ms_clientes.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El rut es obligatorio")
    private String rut;

    @Email(message = "Correo invalido")
    private String correo;

    @NotBlank(message = "El telefono es obligatorio")
    private String telefono;
}