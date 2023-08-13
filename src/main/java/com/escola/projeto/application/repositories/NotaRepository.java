package com.escola.projeto.application.repositories;

import com.escola.projeto.domain.entities.Atividade;
import com.escola.projeto.domain.entities.Estudante;
import com.escola.projeto.domain.entities.Nota;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepository extends MongoRepository<Nota, String> {
    List<Nota> findByEstudanteAndAtividade(Estudante estudante, Atividade atividade);


    List<Nota> findByEstudante(Estudante estudante);

    List<Nota> findByAtividade(Atividade atividade);

    List<Nota> findByEstudante_Cpf(String cpf);

    List<Nota> findByEstudante_Email(String cpf);

    List<Nota> findByEstudante_Telefone(String email);
}
