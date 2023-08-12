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
public class EstudanteRequestDTO {
    @NotNull
    @NotEmpty
    private String cpf;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String telefone;
    @NotEmpty
    private String email;

    public EstudanteRequestDTO(Estudante estudante) {
        this.setCpf(estudante.getCpf());
        this.setNome(estudante.getNome());
        this.setTelefone(estudante.getTelefone());
        this.setEmail(estudante.getEmail());
    }
}
