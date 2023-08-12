package com.escola.projeto.domain.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document(collection = "estudantes")
public class Estudante {
    @Id
    private String id;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;
}
