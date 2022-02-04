package com.crudeventos.crudeventos.models;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ConvidadoRepository extends CrudRepository<ConvidadoModel, String> {
	public Iterable<ConvidadoModel> findByEvento(EventoModel evento);
}
