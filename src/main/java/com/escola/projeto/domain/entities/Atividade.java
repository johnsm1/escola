package com.escola.projeto.domain.entities;

import com.escola.projeto.application.dtos.AtividadeRequestDTO;
import com.escola.projeto.application.dtos.AtividadeResponseDTO;
import com.escola.projeto.application.dtos.AtividadeUpdateRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "atividades")
public class Atividade {
    @Id
    private String id;
    @Indexed(unique = true)
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
        this.setId(atividadeResponseDTO.getId());
        this.setTitulo(atividadeResponseDTO.getTitulo());
        this.setEnunciado(atividadeResponseDTO.getEnunciado());
        this.setDataAtualizacao(LocalDateTime.now());
        this.setDataCadastro(LocalDateTime.now());
    }

    public Atividade(AtividadeUpdateRequestDTO atividadeUpdateRequestDTO,AtividadeResponseDTO oldAtividade) {
        this.setId(oldAtividade.getId());
        this.setTitulo(atividadeUpdateRequestDTO.getTitulo());
        this.setEnunciado(atividadeUpdateRequestDTO.getEnunciado());
        this.setDataAtualizacao(LocalDateTime.now());
        this.setDataCadastro(oldAtividade.getDataCadastro());
    }
}
