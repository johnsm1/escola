package com.escola.projeto.application.services;

import com.escola.projeto.application.dtos.*;

import java.util.List;

public interface EstudanteService {
    public void Cadastro(EstudanteRequestDTO estudanteRequestDTO);

    public EstudanteResponseDTO Busca(String id);

    public List<EstudanteResponseDTO> BuscarTodos(PageFilterDTO page);

    public void atualiza(EstudanteUpdateRequestDTO estudanteUpdateRequestDTO);

    public void deleta(String id);
}
