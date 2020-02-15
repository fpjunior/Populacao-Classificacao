package com.arthurvinicius.cursomc.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "classificacao")
public class Classificacao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String descricao;

	@JsonIgnore
	@OneToMany(mappedBy = "classificacao")
	private List<Populacao> populacao;

	public Classificacao() {
	}
	
	public Classificacao(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Populacao> getPopulacao() {
		return populacao;
	}

	public void setPopulacao(List<Populacao> populacao) {
		this.populacao = populacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
