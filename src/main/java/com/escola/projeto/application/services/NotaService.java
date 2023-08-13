package com.escola.projeto.application.services;

import com.escola.projeto.application.dtos.*;
import com.escola.projeto.domain.entities.Nota;

import java.util.List;

public interface NotaService {
    public String cadastro(NotaRequestDTO notaRequestDTO);

    public void adicionaEstudante(Nota nota);

    public void adicionaAtividade(Nota nota);

    public NotaResponseDTO busca(String id);

    public List<NotaResponseDTO> buscarTodas(PageFilterDTO page);

    public void atualiza(String id,NotaUpdateRequestDTO notaUpdateRequestDTO);

    public void deleta(String id);
}
