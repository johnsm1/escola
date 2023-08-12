package com.escola.projeto.application.dtos;

import com.escola.projeto.domain.entities.Estudante;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudanteUpdateRequestDTO {
    private String id;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;

    public EstudanteUpdateRequestDTO(Estudante estudante) {
        this.setCpf(estudante.getCpf());
        this.setNome(estudante.getNome());
        this.setTelefone(estudante.getTelefone());
        this.setEmail(estudante.getEmail());
    }
}
