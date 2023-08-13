package com.escola.projeto.application.dtos;

import com.escola.projeto.domain.entities.Nota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaUpdateRequestDTO {
    private String id;
    @NotNull(message = "A nota não deve ser preenchida")
    private BigDecimal nota;

    public NotaUpdateRequestDTO(Nota nota) {

        this.setId(nota.getId());
    }
}
