package com.escola.projeto.application.api.controllers;

import com.escola.projeto.application.dtos.*;
import com.escola.projeto.application.services.EstudanteService;
import com.escola.projeto.application.services.NotaService;
import com.escola.projeto.infrastructure.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {
    @Autowired
    private NotaService notaService;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrarAtividade(@Valid @RequestBody final NotaRequestDTO notaRequestDTO) {
        String id = notaService.cadastro(notaRequestDTO);
        String idRetorno = String.format("id:%s", id);
        return ResponseEntity.status(HttpStatus.CREATED).body(idRetorno);
    }

    @GetMapping("/busca/{id}")
    public ResponseEntity<?> buscarEstudante(@PathVariable final String id) {
        try {
            NotaResponseDTO notaResponseDTO = notaService.busca(id);
            return ResponseEntity.ok(notaResponseDTO);
        } catch (ApiException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<List<NotaResponseDTO>> buscarTodasNotas(final PageFilterDTO page) {
        List<NotaResponseDTO> notas = notaService.buscarTodas(page);
        return ResponseEntity.ok(notas);
    }

    @PutMapping("/atualiza/{id}")
    public ResponseEntity<?> atualizarNota(
            @PathVariable final String id,
            @RequestBody final NotaUpdateRequestDTO notaUpdateRequestDTO) {
        try {
            notaService.atualiza(id,notaUpdateRequestDTO);
        } catch (ApiException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Nota atualizada com sucesso.");
    }

    @DeleteMapping("/deleta/{id}")
    public ResponseEntity<String> deletarEstudante(@PathVariable final String id) {
        try {
            notaService.deleta(id);
        } catch (ApiException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok("Nota deletada com sucesso.");

    }
}
