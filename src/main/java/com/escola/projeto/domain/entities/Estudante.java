package com.escola.projeto.domain.entities;

import com.escola.projeto.application.dtos.EstudanteRequestDTO;
import com.escola.projeto.application.dtos.EstudanteResponseDTO;
import com.escola.projeto.application.dtos.EstudanteUpdateRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "estudantes")
public class Estudante {
    @Id
    private String id;
    @Indexed(unique = true)
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;

    public Estudante(EstudanteRequestDTO estudanteRequestDTO) {
        this.setId(estudanteRequestDTO.getId());
        this.setCpf(estudanteRequestDTO.getCpf());
        this.setNome(estudanteRequestDTO.getNome());
        this.setTelefone(estudanteRequestDTO.getTelefone());
        this.setEmail(estudanteRequestDTO.getEmail());
        this.setDataAtualizacao(LocalDateTime.now());
        this.setDataCadastro(LocalDateTime.now());
    }

    public Estudante(EstudanteUpdateRequestDTO estudanteUpdateRequestDTO) {
        this.setCpf(estudanteUpdateRequestDTO.getCpf());
        this.setNome(estudanteUpdateRequestDTO.getNome());
        this.setTelefone(estudanteUpdateRequestDTO.getTelefone());
        this.setEmail(estudanteUpdateRequestDTO.getEmail());
        this.setDataAtualizacao(LocalDateTime.now());
    }

    public Estudante(EstudanteResponseDTO estudanteResponseDTO) {
        this.setCpf(estudanteResponseDTO.getCpf());
        this.setNome(estudanteResponseDTO.getNome());
        this.setTelefone(estudanteResponseDTO.getTelefone());
        this.setEmail(estudanteResponseDTO.getEmail());
        this.setDataAtualizacao(LocalDateTime.now());
    }
}
