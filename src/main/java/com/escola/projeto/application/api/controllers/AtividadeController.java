package com.escola.projeto.application.api.controllers;

import com.escola.projeto.application.dtos.AtividadeRequestDTO;
import com.escola.projeto.application.dtos.AtividadeResponseDTO;
import com.escola.projeto.application.dtos.AtividadeUpdateRequestDTO;
import com.escola.projeto.application.dtos.PageFilterDTO;
import com.escola.projeto.application.services.AtividadeService;
import com.escola.projeto.infrastructure.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrarAtividade(@Valid @RequestBody final AtividadeRequestDTO atividadeRequestDTO) {
        String id = atividadeService.cadastro(atividadeRequestDTO);
        String idRetorno = String.format("id:%s", id);
        return ResponseEntity.status(HttpStatus.CREATED).body(idRetorno);
    }

    @GetMapping("/busca/{id}")
    public ResponseEntity<?> buscarAtividade(@PathVariable String id) {
        try {
            AtividadeResponseDTO atividadeResponseDTO = atividadeService.busca(id);
            return ResponseEntity.ok(atividadeResponseDTO);
        } catch (ApiException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<List<AtividadeResponseDTO>> buscarTodasAtividades(final PageFilterDTO page) {
        List<AtividadeResponseDTO> atividades = atividadeService.buscarTodos(page);
        return ResponseEntity.ok(atividades);
    }

    @PutMapping("/atualiza/{id}")
    public ResponseEntity<String> atualizarAtividade(
            @PathVariable final String id,
            @RequestBody final AtividadeUpdateRequestDTO atividadeUpdateRequestDTO) {
        try {
            atividadeService.atualiza(id, atividadeUpdateRequestDTO);
        } catch (ApiException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Atividade atualizada com sucesso.");
    }

    @DeleteMapping("/deleta/{id}")
    public ResponseEntity<String> deletarAtividade(@PathVariable final String id) {
        try {
            atividadeService.deleta(id);
        } catch (ApiException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok("Atividade deletada com sucesso.");
    }


}
