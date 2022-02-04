package com.crudeventos.crudeventos.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="convidado")
public class ConvidadoModel implements Serializable {

	@Id
	private String rg;
	private String nome;
	
	@ManyToOne
	private EventoModel evento;
	
	public ConvidadoModel() {}

	public ConvidadoModel(String rg, String nome) {
		this.rg = rg;
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EventoModel getEvento() {
		return evento;
	}

	public void setEvento(EventoModel evento) {
		this.evento = evento;
	}
}
