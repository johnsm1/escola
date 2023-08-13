package com.escola.projeto.application.services.implementations;

import com.escola.projeto.application.dtos.*;
import com.escola.projeto.application.repositories.AtividadeRepository;
import com.escola.projeto.application.repositories.EstudanteRepository;
import com.escola.projeto.application.repositories.NotaRepository;
import com.escola.projeto.application.services.NotaService;
import com.escola.projeto.domain.entities.Atividade;
import com.escola.projeto.domain.entities.Estudante;
import com.escola.projeto.domain.entities.Nota;
import com.escola.projeto.infrastructure.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotaServiceImpl implements NotaService {
    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private AtividadeRepository atividadeRepository;

    /**
     * @param notaRequestDTO
     * cadastra nova nota
     */
    @Override
    @Transactional
    public String cadastro(NotaRequestDTO notaRequestDTO) {
        Nota nota = new Nota(notaRequestDTO);
        this.adicionaEstudante(nota);
        this.adicionaAtividade(nota);
        return notaRepository.save(nota).getId();
    }

    /**
     * @param nota
     * vincula um estudante a nota
     */
    @Override
    @Transactional
    public void adicionaEstudante(Nota nota) {
        Optional<Estudante> estudanteOptional = estudanteRepository.findById(nota.getId());
        Estudante estudante = estudanteOptional.get();
        nota.setEstudante(estudante);
    }

    /**
     * @param nota
     * vincula uma atividade a uma nota
     */
    @Override
    @Transactional
    public void adicionaAtividade(Nota nota) {
        Optional<Atividade> atividadeOptional = atividadeRepository.findById(nota.getId());
        Atividade atividade = atividadeOptional.get();
        nota.setAtividade(atividade);
    }

    /**
     * @param id
     * @return
     * busca pelo id uma nota
     */
    @Override
    @Transactional
    public NotaResponseDTO busca(String id) {
        Optional<Nota> nota = notaRepository.findById(id);
        if (nota.isEmpty()) {
            throw new ApiException("Não existe nota com o id informado");
        }
        NotaResponseDTO notaResponseDTO = new NotaResponseDTO(nota.get());
        return notaResponseDTO;
    }

    /**
     * @param page
     * @return
     * busca todas notas
     */
    @Override
    @Transactional
    public List<NotaResponseDTO> buscarTodas(PageFilterDTO page) {
        Page<Nota> notas = notaRepository.findAll(PageRequest.of(page.getPage(), page.getSize()));
        List<NotaResponseDTO> notaResponseDTOS = notas.getContent()
                .stream()
                .map(NotaResponseDTO::new)
                .collect(Collectors.toList());
        return notaResponseDTOS;

    }


    /**
     * @param id
     * @param notaUpdateRequestDTO
     * atualiza uma nota
     */
    @Override
    @Transactional
    public void atualiza(String id,NotaUpdateRequestDTO notaUpdateRequestDTO) {
        Nota nota = new Nota(id,notaUpdateRequestDTO);
        notaRepository.save(nota);
    }

    /**
     * @param id
     * deleta uma nota
     */
    @Override
    @Transactional
    public void deleta(String id) {
        NotaResponseDTO notaResponseDTO = this.busca(id);
        Nota nota = new Nota(notaResponseDTO);
        notaRepository.delete(nota);
    }
}
