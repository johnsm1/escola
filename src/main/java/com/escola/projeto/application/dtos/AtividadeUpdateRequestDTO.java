package com.escola.projeto.application.dtos;

import com.escola.projeto.domain.entities.Atividade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtividadeUpdateRequestDTO {

    private String titulo;
    private String enunciado;


    public AtividadeUpdateRequestDTO(Atividade atividade) {
        this.setTitulo(atividade.getTitulo());
        this.setEnunciado(atividade.getEnunciado());
    }
}
