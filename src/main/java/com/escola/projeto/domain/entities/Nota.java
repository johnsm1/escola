package com.escola.projeto.domain.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "notas")
public class Nota {
    @Id
    private String id;
    private String estudanteId;
    private String atividadeId;
    private double nota;
}
