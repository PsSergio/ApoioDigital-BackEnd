package com.apoiodigital.main.api.Repositories;

import com.apoiodigital.main.api.Models.Requisicao;
import com.apoiodigital.main.api.Models.Historico;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HistoricoRepository extends MongoRepository<Historico, Long> {

    List<Historico> findRespostaPrintScreenByRequisicao(Requisicao requisicao);

}
