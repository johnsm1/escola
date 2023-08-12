package com.escola.projeto.application.services.implementations;

import com.escola.projeto.application.dtos.*;
import com.escola.projeto.application.services.NotaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaServiceImpl implements NotaService {
    /**
     * @param estudanteRequestDTO
     */
    @Override
    public void Cadastro(NotaRequestDTO estudanteRequestDTO) {

    }

    /**
     * @param id
     * @return
     */
    @Override
    public NotaResponseDTO Busca(String id) {
        return null;
    }

    /**
     * @param page
     * @return
     */
    @Override
    public List<NotaResponseDTO> BuscarTodos(PageFilterDTO page) {
        return null;
    }

    /**
     * @param notaUpdateRequestDTO
     */
    @Override
    public void atualiza(NotaUpdateRequestDTO notaUpdateRequestDTO) {

    }

    /**
     * @param id
     */
    @Override
    public void deleta(String id) {

    }
}
