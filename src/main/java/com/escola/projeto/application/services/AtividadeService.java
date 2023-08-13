package com.escola.projeto.application.services;

import com.escola.projeto.application.dtos.AtividadeRequestDTO;
import com.escola.projeto.application.dtos.AtividadeResponseDTO;
import com.escola.projeto.application.dtos.AtividadeUpdateRequestDTO;
import com.escola.projeto.application.dtos.PageFilterDTO;
import com.escola.projeto.domain.entities.Atividade;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface AtividadeService {

    public String cadastro(AtividadeRequestDTO atividadeRequestDTO);

    public AtividadeResponseDTO busca(String id);

    public List<AtividadeResponseDTO> buscarTodos(PageFilterDTO page);

    public void atualiza(String id,AtividadeUpdateRequestDTO atividadeUpdateRequestDTO);

    public void deleta(String id);


}
