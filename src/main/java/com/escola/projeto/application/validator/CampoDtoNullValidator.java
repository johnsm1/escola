package com.escola.projeto.application.validator;

import com.escola.projeto.application.dtos.EstudanteUpdateRequestDTO;
import com.escola.projeto.infrastructure.exceptions.ApiException;
import org.springframework.stereotype.Component;

@Component
public class CampoDtoNullValidator {
    public String validate(EstudanteUpdateRequestDTO estudanteUpdateRequestDTO) {
        String cpf = estudanteUpdateRequestDTO.getCpf();
        String email = estudanteUpdateRequestDTO.getEmail();
        String telefone = estudanteUpdateRequestDTO.getTelefone();

        int camposPreenchidos = 0;
        String campoPreenchido = null;

        if (estudanteUpdateRequestDTO.getCpf() != null) {
            camposPreenchidos++;
            campoPreenchido = "cpf";
        }
        if (estudanteUpdateRequestDTO.getEmail() != null) {
            camposPreenchidos++;
            campoPreenchido = "email";
        }
        if (estudanteUpdateRequestDTO.getTelefone() != null) {
            camposPreenchidos++;
            campoPreenchido = "telefone";
        }
        if (camposPreenchidos != 1) {
            throw new ApiException("mais de um campo preenchido");
        }
        return campoPreenchido;
    }
}

