package com.escola.projeto.application.services.implementations;

import com.escola.projeto.application.dtos.AtividadeRequestDTO;
import com.escola.projeto.application.dtos.AtividadeResponseDTO;
import com.escola.projeto.application.dtos.AtividadeUpdateRequestDTO;
import com.escola.projeto.application.dtos.PageFilterDTO;
import com.escola.projeto.application.repositories.AtividadeRepository;
import com.escola.projeto.application.services.AtividadeService;
import com.escola.projeto.domain.entities.Atividade;
import com.escola.projeto.infrastructure.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AtividadeServiceImpl implements AtividadeService {

    @Autowired
    AtividadeRepository atividadeRepository;

    /**
     * cadastra nova atividade
     */
    @Override
    @Transactional
    public String Cadastro(AtividadeRequestDTO atividadeRequestDTO) {
        Atividade atividade = new Atividade(atividadeRequestDTO);
        Atividade savedAtividade = atividadeRepository.save(atividade);
        return savedAtividade.getId();
    }

    /**
     * @param id
     * @return busca uma atividade pelo id
     */
    @Override
    @Transactional
    public AtividadeResponseDTO Busca(String id) {
        Optional<Atividade> atividade = atividadeRepository.findById(id);
        if (atividade.isEmpty()) {
            throw new ApiException("id não encontrado");
        }
        AtividadeResponseDTO atividadeResponseDTO = new AtividadeResponseDTO(atividade.get());
        return atividadeResponseDTO;
    }

    /**
     * busca todas atividades
     *
     * @return
     */
    @Override
    public List<AtividadeResponseDTO> BuscarTodos(PageFilterDTO page) {
        Page<Atividade> atividades = atividadeRepository.findAll(PageRequest.of(page.getPage(), page.getSize()));
        List<AtividadeResponseDTO> atividadeResponseDTOS = atividades.getContent()
                .stream()
                .map(AtividadeResponseDTO::new)
                .collect(Collectors.toList());
        return atividadeResponseDTOS;
    }

    /**
     * atualiza campos de atividades
     *
     * @param atividadeUpdateRequestDTO
     */
    @Override
    @Transactional
    public void atualiza(String id, AtividadeUpdateRequestDTO atividadeUpdateRequestDTO) {
        AtividadeResponseDTO oldAtividade = this.Busca(id);
        if (oldAtividade.getId() == null) {
            throw new ApiException("Atividade não existe");
        }
        Atividade atividade = new Atividade(atividadeUpdateRequestDTO, oldAtividade);
        atividadeRepository.save(atividade);
    }

    /**
     * @param id deleta atividade por id
     */
    @Override
    public void deleta(String id) {
        AtividadeResponseDTO atividadeResponseDTO = this.Busca(id);
        if (atividadeResponseDTO.getId() == null) {
            throw new ApiException("atividade não existe");
        }
        Atividade atividade = new Atividade(atividadeResponseDTO);
        atividadeRepository.delete(atividade);
    }


}
