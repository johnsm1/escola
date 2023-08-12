package com.escola.projeto.application.repositories;

import com.escola.projeto.domain.entities.Estudante;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudanteRepository extends MongoRepository<Estudante, String> {
}
