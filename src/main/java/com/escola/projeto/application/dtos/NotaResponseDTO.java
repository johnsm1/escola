package com.escola.projeto.application.dtos;

import com.escola.projeto.domain.entities.Atividade;
import com.escola.projeto.domain.entities.Estudante;
import com.escola.projeto.domain.entities.Nota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaResponseDTO {
    private String id;
    private Estudante estudante;
    private Atividade atividade;
    private BigDecimal nota;

    public NotaResponseDTO(Nota nota) {
        this.setId(nota.getId());
        this.setEstudante(nota.getEstudante());
        this.setAtividade(nota.getAtividade());
        this.setNota(nota.getNota());
    }
}
