package com.escola.projeto.application.services.implementations;

import com.escola.projeto.application.dtos.EstudanteUpdateRequestDTO;
import com.escola.projeto.application.helpers.Calculo;
import com.escola.projeto.application.repositories.AtividadeRepository;
import com.escola.projeto.application.repositories.EstudanteRepository;
import com.escola.projeto.application.repositories.NotaRepository;
import com.escola.projeto.application.services.MediaNotasService;
import com.escola.projeto.application.validator.CampoDtoNullValidator;
import com.escola.projeto.domain.entities.Atividade;
import com.escola.projeto.domain.entities.Estudante;
import com.escola.projeto.domain.entities.Nota;
import com.escola.projeto.infrastructure.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MediaNotasServiceImpl implements MediaNotasService {

    @Autowired
    private Calculo calculo;
    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    CampoDtoNullValidator campoDtoNullValidator;

    @Autowired
    private AtividadeRepository atividadeRepository;

    /**
     * @param estudante
     * @param atividade
     * @return
     */
    @Override
    public BigDecimal mediaGeralNaAtividade(Estudante estudante, Atividade atividade) {
        List<Nota> notasDoEstudanteNaAtividade = notaRepository.findByEstudanteAndAtividade(estudante, atividade);
        if (notasDoEstudanteNaAtividade.isEmpty()) {
            throw new ApiException("o estudante não tem notas");
        }
        BigDecimal media = calculo.calculaMediaDeListaNotas(notasDoEstudanteNaAtividade);
        return media;
    }

    /**
     * @param estudante
     * @return
     */
    @Override
    public BigDecimal mediaGeral(Estudante estudante) {
        List<Nota> notasDoEstudante = notaRepository.findByEstudante(estudante);
        if (notasDoEstudante.isEmpty()) {
            throw new ApiException("o estudante não tem notas");
        }
        BigDecimal media = calculo.calculaMediaDeListaNotas(notasDoEstudante);
        return media;

    }

    /**
     * @param atividade
     * @return
     */
    @Override
    public BigDecimal mediaAtividadeTodosEstudantes(Atividade atividade) {
        List<Nota> notasDaAtividade = notaRepository.findByAtividade(atividade);
        if (notasDaAtividade.isEmpty()) {
            throw new ApiException("o estudante não tem notas");
        }
        BigDecimal media = calculo.calculaMediaDeListaNotas(notasDaAtividade);
        return media;
    }

    /**
     * @param estudanteUpdateRequestDTO
     * @return
     */
    @Override
    public BigDecimal todasNotasPorEstudante(EstudanteUpdateRequestDTO estudanteUpdateRequestDTO) {
        String identificadorCampo = campoDtoNullValidator.validate(estudanteUpdateRequestDTO);
        List<Nota> notasTodosAlunos = null;
        switch (identificadorCampo) {
            case "cpf":
                notasTodosAlunos = notaRepository.findByEstudante_Cpf(estudanteUpdateRequestDTO.getCpf());
                break;
            case "email":
                notasTodosAlunos = notaRepository.findByEstudante_Email(estudanteUpdateRequestDTO.getEmail());
                break;
            case "telefone":
                notasTodosAlunos = notaRepository.findByEstudante_Telefone(estudanteUpdateRequestDTO.getTelefone());
                break;
        }
        if (notasTodosAlunos.isEmpty()) {
            throw new ApiException("o estudante não tem notas");
        }
        BigDecimal media = calculo.calculaMediaDeListaNotas(notasTodosAlunos);
        return media;
    }
}
