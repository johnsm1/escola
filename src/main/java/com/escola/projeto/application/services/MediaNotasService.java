package com.escola.projeto.application.services;

import com.escola.projeto.application.dtos.EstudanteUpdateRequestDTO;
import com.escola.projeto.domain.entities.Atividade;
import com.escola.projeto.domain.entities.Estudante;
import com.escola.projeto.domain.entities.Nota;

import java.math.BigDecimal;
import java.util.List;

public interface MediaNotasService {
    public BigDecimal mediaGeralNaAtividade(Estudante estudante, Atividade atividade);

    public BigDecimal mediaGeral(Estudante estudante);

    public BigDecimal mediaAtividadeTodosEstudantes(Atividade atividade);

    public BigDecimal todasNotasPorEstudante(EstudanteUpdateRequestDTO estudanteUpdateRequestDTO);

}
