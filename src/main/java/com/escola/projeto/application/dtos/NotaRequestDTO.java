package com.escola.projeto.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaRequestDTO {
    private String id;
    @NotNull
    @NotEmpty
    private String estudanteCpf;
    @NotNull
    @NotEmpty
    private String atividadeTitulo;
    @NotNull
    private double nota;
}
