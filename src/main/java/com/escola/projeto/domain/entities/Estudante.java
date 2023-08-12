package com.escola.projeto.domain.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "estudantes")
public class Estudante {
    @Id
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;
}
