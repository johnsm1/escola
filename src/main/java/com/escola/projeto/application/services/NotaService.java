package com.escola.projeto.application.services;

import com.escola.projeto.application.dtos.*;

import java.util.List;

public interface NotaService {
    public void Cadastro(NotaRequestDTO notaRequestDTO);

    public NotaResponseDTO Busca(String id);

    public List<NotaResponseDTO> BuscarTodos(PageFilterDTO page);

    public void atualiza(NotaUpdateRequestDTO notaUpdateRequestDTO);

    public void deleta(String id);
}
