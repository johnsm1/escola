package com.escola.projeto.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaUpdateRequestDTO {
    private String id;
    private String estudanteId;
    private String atividadeId;
    private double nota;
}
