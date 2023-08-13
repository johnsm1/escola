package com.escola.projeto.application.repositories;

import com.escola.projeto.domain.entities.Nota;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends MongoRepository<Nota, String> {
    Nota findByEstudante_IdAndAtividade_Id(String estudanteId,String atividadeId);
}
