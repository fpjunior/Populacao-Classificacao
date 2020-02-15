package com.arthurvinicius.cursomc.Dto;

import java.util.ArrayList;
import java.util.List;

import com.arthurvinicius.cursomc.domain.Classificacao;
import com.arthurvinicius.cursomc.domain.Populacao;

public class PopulacaoDto {

	private Integer id;
	private String cnes;
	private Integer ano;

	private List<ClassificacaoDto> classificacoes = new ArrayList<>();

	public static PopulacaoDto parseDto(Classificacao classificacao) {
		List<Populacao> populacao = classificacao.getPopulacao();
		return new PopulacaoDto();

	}

	public List<Populacao> toObject() {
		List<Populacao> populacoes = new ArrayList<Populacao>();
		for (ClassificacaoDto classificacaoDto : classificacoes) {
			Classificacao classificacao = new Classificacao(classificacaoDto.getId());
			Populacao populacao = new Populacao(null, ano, classificacaoDto.getQnt(), cnes, classificacao);
			populacoes.add(populacao);
		}
		return populacoes;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCnes() {
		return cnes;
	}

	public void setCnes(String cnes) {
		this.cnes = cnes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public List<ClassificacaoDto> getClassificacoes() {
		return classificacoes;
	}

	public void setClassificoes(List<ClassificacaoDto> classificacoes) {
		this.classificacoes = classificacoes;
	}

}
