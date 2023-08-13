package com.escola.projeto.application.dtos;

import com.escola.projeto.domain.entities.Estudante;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudanteRequestDTO {

    private String id;
    @NotNull(message = "é necessario informar o cpf para cadastro")
    @NotBlank(message = "é necessario informar o cpf para cadastro")
    private String cpf;
    @NotBlank(message = "é necessario informar o nome para cadastro")
    private String nome;
    @NotNull(message = "é necessario informar o telefone para cadastro")
    @NotBlank(message = "é necessario informar o telefone para cadastro")
    private String telefone;
    @Email(message = "email não é valido")
    private String email;

    public EstudanteRequestDTO(Estudante estudante) {
        this.setId(estudante.getId());
        this.setCpf(estudante.getCpf());
        this.setNome(estudante.getNome());
        this.setTelefone(estudante.getTelefone());
        this.setEmail(estudante.getEmail());
    }
}
