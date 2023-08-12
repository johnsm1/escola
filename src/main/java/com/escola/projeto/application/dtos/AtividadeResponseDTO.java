package com.escola.projeto.application.dtos;

import com.escola.projeto.domain.entities.Atividade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtividadeResponseDTO {
    private String id;
    private String titulo;
    private String enunciado;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;

    public AtividadeResponseDTO(Atividade atividade) {
        this.setId(atividade.getId());
        this.setTitulo(atividade.getTitulo());
        this.setEnunciado(atividade.getEnunciado());
        this.setDataCadastro(atividade.getDataCadastro());
        this.setDataAtualizacao(atividade.getDataAtualizacao());

    }
}
