package com.escola.projeto.application.helpers;

import com.escola.projeto.domain.entities.Nota;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Calculo {

    public BigDecimal calculaMediaDeListaNotas(List<Nota> notas) {
        BigDecimal totalNotas = BigDecimal.valueOf(notas.size());
        BigDecimal soma = notas.stream()
                .map(Nota::getNota)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal media = soma.divide(totalNotas, 2, BigDecimal.ROUND_HALF_UP);
        return media;
    }
}
