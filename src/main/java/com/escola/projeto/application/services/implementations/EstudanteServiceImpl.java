package com.escola.projeto.application.services.implementations;

import com.escola.projeto.application.dtos.*;
import com.escola.projeto.application.repositories.EstudanteRepository;
import com.escola.projeto.application.services.EstudanteService;
import com.escola.projeto.domain.entities.Atividade;
import com.escola.projeto.domain.entities.Estudante;
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
public class EstudanteServiceImpl implements EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;
    /**
     * @param estudanteRequestDTO
     * cadastra estudante
     */
    @Override
    @Transactional
    public String cadastro(EstudanteRequestDTO estudanteRequestDTO) {
        Estudante estudante = new Estudante(estudanteRequestDTO);
        return estudanteRepository.save(estudante).getId();
    }

    /**
     * @param id
     * @return
     * busca estudante pelo id
     */
    @Override
    @Transactional
    public EstudanteResponseDTO busca(String id) {
        Optional<Estudante> estudante = estudanteRepository.findById(id);
        if (estudante.isEmpty()) {
            throw new ApiException("Não existe atividade com o id informado");
        }
        EstudanteResponseDTO estudanteResponseDTO = new EstudanteResponseDTO(estudante.get());
        return estudanteResponseDTO;
    }

    /**
     * @param page
     * @return
     * busca todos estudantes
     */
    @Override
    @Transactional
    public List<EstudanteResponseDTO> buscarTodos(PageFilterDTO page) {
        Page<Estudante> estudantes = estudanteRepository.findAll(PageRequest.of(page.getPage(), page.getSize()));
        List<EstudanteResponseDTO> EstudanteResponseDTOS = estudantes.getContent()
                .stream()
                .map(EstudanteResponseDTO::new)
                .collect(Collectors.toList());
        return EstudanteResponseDTOS;
    }

    /**
     * @param estudanteUpdateRequestDTO
     * atualiza um estudante
     */
    @Override
    @Transactional
    public void atualiza(String id,EstudanteUpdateRequestDTO estudanteUpdateRequestDTO) {
        Estudante estudante = new Estudante(estudanteUpdateRequestDTO);
        estudanteRepository.save(estudante);
    }

    /**
     * @param id
     * deleta um estudante
     */
    @Override
    @Transactional
    public void deleta(String id) {
        EstudanteResponseDTO estudanteResponseDTO = this.busca(id);
        Estudante estudante = new Estudante(estudanteResponseDTO);
        estudanteRepository.delete(estudante);
    }
}
