package com.escola.projeto.application.services;

import com.escola.projeto.application.dtos.AtividadeRequestDTO;
import com.escola.projeto.application.dtos.AtividadeResponseDTO;
import com.escola.projeto.application.dtos.AtividadeUpdateRequestDTO;
import com.escola.projeto.application.dtos.PageFilterDTO;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface AtividadeService {

    public void Cadastro(AtividadeRequestDTO atividadeRequestDTO);

    public AtividadeResponseDTO Busca(String id);

    public List<AtividadeResponseDTO> BuscarTodos(PageFilterDTO page);

    public void atualiza(AtividadeUpdateRequestDTO atividadeUpdateRequestDTO);

    public void deleta(String id);


}
