package com.escola.projeto.application.api.controllers;

import com.escola.projeto.application.dtos.*;
import com.escola.projeto.application.services.EstudanteService;
import com.escola.projeto.infrastructure.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrarAtividade(@Valid @RequestBody final EstudanteRequestDTO estudanteRequestDTO) {
        String id = estudanteService.cadastro(estudanteRequestDTO);
        String idRetorno = String.format("id:%s", id);
        return ResponseEntity.status(HttpStatus.CREATED).body(idRetorno);
    }

    @GetMapping("/public/busca/{id}")
    public ResponseEntity<?> buscarEstudante(@PathVariable final String id) {
        try {
            EstudanteResponseDTO estudanteResponseDTO = estudanteService.busca(id);
            return ResponseEntity.ok(estudanteResponseDTO);
        } catch (ApiException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/public/buscar-todos")
    public ResponseEntity<List<EstudanteResponseDTO>> buscarTodasEstudante(final PageFilterDTO page) {
        List<EstudanteResponseDTO> estudantes = estudanteService.buscarTodos(page);
        return ResponseEntity.ok(estudantes);
    }

    @PutMapping("/atualiza/{id}")
    public ResponseEntity<?> atualizarEstudante(
            @PathVariable final String id,
            @RequestBody final EstudanteUpdateRequestDTO estudanteUpdateRequestDTO) {
        try {
            estudanteService.atualiza(id, estudanteUpdateRequestDTO);
        } catch (ApiException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Estudante atualizado com sucesso.");
    }

    @DeleteMapping("/deleta/{id}")
    public ResponseEntity<String> deletarEstudante(@PathVariable final String id) {
        try {
            estudanteService.deleta(id);
        } catch (ApiException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok("Estudante deletado com sucesso.");

    }
}
