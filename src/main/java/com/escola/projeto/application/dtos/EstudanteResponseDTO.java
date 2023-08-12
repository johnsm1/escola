package com.escola.projeto.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudanteResponseDTO  {
    private String id;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
}
