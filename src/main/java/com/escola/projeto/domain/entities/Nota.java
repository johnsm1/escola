package com.escola.projeto.domain.entities;

import com.escola.projeto.application.dtos.NotaRequestDTO;
import com.escola.projeto.application.dtos.NotaResponseDTO;
import com.escola.projeto.application.dtos.NotaUpdateRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "notas")
public class Nota {
    @Id
    private String id;
    @DBRef
    private Estudante estudante;
    @DBRef
    private Atividade atividade;
    private BigDecimal nota;

    public Nota(NotaRequestDTO notaRequestDTO) {
        this.setId(notaRequestDTO.getId());
        this.setNota(notaRequestDTO.getNota());
    }
    public Nota(String id,NotaUpdateRequestDTO notaUpdateRequestDTO) {
        this.setId(id);
        this.setNota(notaUpdateRequestDTO.getNota());
    }
    public Nota(NotaResponseDTO notaResponseDTO) {
        this.setId(notaResponseDTO.getId());
        this.setNota(notaResponseDTO.getNota());
    }
}
