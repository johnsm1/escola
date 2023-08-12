package com.escola.projeto.domain.entities;

import com.escola.projeto.application.dtos.AtividadeRequestDTO;
import com.escola.projeto.application.dtos.AtividadeResponseDTO;
import com.escola.projeto.application.dtos.AtividadeUpdateRequestDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document(collection = "atividades")
public class Atividade {
    @Id
    private String id;
    private String titulo;
    private String enunciado;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;

    public Atividade(AtividadeRequestDTO atividadeRequestDTO) {
        this.setTitulo(atividadeRequestDTO.getTitulo());
        this.setEnunciado(atividadeRequestDTO.getEnunciado());
        this.setDataAtualizacao(LocalDateTime.now());
        this.setDataCadastro(LocalDateTime.now());
    }

    public Atividade(AtividadeResponseDTO atividadeResponseDTO) {
        this.setTitulo(atividadeResponseDTO.getTitulo());
        this.setEnunciado(atividadeResponseDTO.getEnunciado());
        this.setDataAtualizacao(LocalDateTime.now());
        this.setDataCadastro(LocalDateTime.now());
    }

    public Atividade(AtividadeUpdateRequestDTO atividadeUpdateRequestDTO) {
        this.setTitulo(atividadeUpdateRequestDTO.getTitulo());
        this.setEnunciado(atividadeUpdateRequestDTO.getEnunciado());
        this.setDataAtualizacao(LocalDateTime.now());
        this.setDataCadastro(LocalDateTime.now());
    }
}
