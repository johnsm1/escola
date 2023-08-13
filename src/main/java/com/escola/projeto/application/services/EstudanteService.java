package com.escola.projeto.application.services;

import com.escola.projeto.application.dtos.*;
import com.escola.projeto.domain.entities.Nota;

import java.util.List;

public interface EstudanteService {
    public String cadastro(EstudanteRequestDTO estudanteRequestDTO);

    public EstudanteResponseDTO busca(String id);

    public List<EstudanteResponseDTO> buscarTodos(PageFilterDTO page);

    public void atualiza(String id,EstudanteUpdateRequestDTO estudanteUpdateRequestDTO);

    public void deleta(String id);
}
