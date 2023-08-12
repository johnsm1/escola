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

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrarAtividade(@RequestBody AtividadeRequestDTO atividadeRequestDTO) {
        String id = atividadeService.Cadastro(atividadeRequestDTO);
        String idRetorno = String.format("id:%s", id);
        return ResponseEntity.status(HttpStatus.CREATED).body(idRetorno);
    }

    @GetMapping("/busca/{id}")
    public ResponseEntity<?> buscarAtividade(@PathVariable String id) {
        try {
            AtividadeResponseDTO atividadeResponseDTO = atividadeService.Busca(id);
            return ResponseEntity.ok(atividadeResponseDTO);
        } catch (ApiException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<List<AtividadeResponseDTO>> buscarTodasAtividades(PageFilterDTO page) {
        List<AtividadeResponseDTO> atividades = atividadeService.BuscarTodos(page);
        return ResponseEntity.ok(atividades);
    }

    @PutMapping("/atualiza/{id}")
    public ResponseEntity<String> atualizarAtividade(
            @PathVariable String id,
            @RequestBody AtividadeUpdateRequestDTO atividadeUpdateRequestDTO) {
        try {
            atividadeService.atualiza(id, atividadeUpdateRequestDTO);
        } catch (ApiException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Atividade atualizada com sucesso.");
    }

    @DeleteMapping("/deleta/{id}")
    public ResponseEntity<String> deletarAtividade(@PathVariable String id) {
        try {
            atividadeService.deleta(id);
        } catch (ApiException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok("Atividade deletada com sucesso.");
    }


}
