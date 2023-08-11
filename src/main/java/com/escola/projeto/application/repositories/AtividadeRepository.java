package com.escola.projeto.application.repositories;

import com.escola.projeto.domain.entities.Atividade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadeRepository extends MongoRepository<Atividade, String> {
}
