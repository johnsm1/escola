package com.escola.projeto.application.dtos;

import com.escola.projeto.domain.entities.Estudante;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudanteResponseDTO  {
    private String id;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;

    public EstudanteResponseDTO(Estudante estudante) {
        this.setId(estudante.getId());
        this.setCpf(estudante.getCpf());
        this.setNome(estudante.getNome());
        this.setTelefone(estudante.getTelefone());
        this.setEmail(estudante.getEmail());
    }
}
