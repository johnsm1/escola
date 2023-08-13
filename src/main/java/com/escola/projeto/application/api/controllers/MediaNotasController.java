package com.escola.projeto.application.controllers;

import com.escola.projeto.application.dtos.EstudanteUpdateRequestDTO;
import com.escola.projeto.application.repositories.AtividadeRepository;
import com.escola.projeto.application.repositories.EstudanteRepository;
import com.escola.projeto.application.repositories.NotaRepository;
import com.escola.projeto.application.services.MediaNotasService;
import com.escola.projeto.application.services.NotaService;
import com.escola.projeto.domain.entities.Atividade;
import com.escola.projeto.domain.entities.Estudante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api/media-notas")
public class MediaNotasController {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private NotaService notaService;

    @Autowired
    private MediaNotasService mediaNotasService;

    @GetMapping("/public/media-geral/{estudanteId}")
    public ResponseEntity<BigDecimal> calcularMediaGeral(@PathVariable String estudanteId) {

        Optional<Estudante> estudante = estudanteRepository.findById(estudanteId);

        BigDecimal media = mediaNotasService.mediaGeral(estudante.get());
        return ResponseEntity.ok(media);
    }

    @GetMapping("/public/media-atividade/{estudanteId}/{atividadeId}")
    public ResponseEntity<BigDecimal> calcularMediaAtividade(
            @PathVariable String estudanteId,
            @PathVariable String atividadeId) {

        Optional<Estudante> estudante = estudanteRepository.findById(estudanteId);
        Optional<Atividade> atividade = atividadeRepository.findById(atividadeId);

        BigDecimal media = mediaNotasService.mediaGeralNaAtividade(estudante.get(), atividade.get());
        return ResponseEntity.ok(media);
    }

    @GetMapping("/public/media-geral-atividade/{atividadeId}")
    public ResponseEntity<BigDecimal> calcularMediaGeralAtividade(@PathVariable String atividadeId) {

        Optional<Atividade> atividade = atividadeRepository.findById(atividadeId);

        BigDecimal media = mediaNotasService.mediaAtividadeTodosEstudantes(atividade.get());
        return ResponseEntity.ok(media);
    }

    @PostMapping("/public/media-por-campo")
    public ResponseEntity<BigDecimal> calcularMediaPorCampo(@RequestBody EstudanteUpdateRequestDTO requestDTO) {
        BigDecimal media = mediaNotasService.todasNotasPorEstudante(requestDTO);
        return ResponseEntity.ok(media);
    }
}
