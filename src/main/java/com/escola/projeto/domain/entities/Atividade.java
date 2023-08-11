package com.escola.projeto.domain.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Data
@Document(collection = "atividades")
public class Atividade {
    @Id
    private String titulo;
    private String enunciado;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;
}
