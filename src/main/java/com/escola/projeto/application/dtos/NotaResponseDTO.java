package com.escola.projeto.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaResponseDTO {
    private String id;
    private String estudanteId;
    private String atividadeId;
    private double nota;
}
