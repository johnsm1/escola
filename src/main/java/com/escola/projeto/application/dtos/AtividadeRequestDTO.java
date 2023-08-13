package com.escola.projeto.application.dtos;

import com.escola.projeto.domain.entities.Atividade;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtividadeRequestDTO {
    private String id;
    @NotNull(message = "titulo no cadastro não pode estar null")
    @NotBlank(message = "titulo no cadastro não pode estar em branco")
    private String titulo;
    @NotBlank(message = "enunciado no cadastro não pode estar em branco")
    private String enunciado;


    public AtividadeRequestDTO(Atividade atividade) {
        this.setId(atividade.getId());
        this.setTitulo(atividade.getTitulo());
        this.setEnunciado(atividade.getEnunciado());
    }
}
