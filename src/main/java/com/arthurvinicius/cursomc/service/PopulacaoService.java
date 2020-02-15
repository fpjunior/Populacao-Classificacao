package com.arthurvinicius.cursomc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthurvinicius.cursomc.domain.Classificacao;
import com.arthurvinicius.cursomc.domain.Populacao;
import com.arthurvinicius.cursomc.repository.ClassificacaoRepository;
import com.arthurvinicius.cursomc.repository.PopulacaoRepository;

@Service
public class PopulacaoService {

	@Autowired
	public PopulacaoRepository populacaoRepository;

	@Autowired
	public ClassificacaoRepository classificacaoRepository;

	public List<Populacao> findAll() {
		return populacaoRepository.findAll();
	}

	public void inserirPopulacao(Populacao populacao) {
		Classificacao classificacao = classificacaoRepository.findById(populacao.getClassificacao().getId()).get();
		Optional<Populacao> populacaoExistenteOpt = populacaoRepository.findByAnoCnesClassificao(populacao.getAno(), populacao.getCnes(), populacao.getClassificacao().getId());
		if (populacaoExistenteOpt.isPresent()) {
			Populacao populacaoExistente  = populacaoExistenteOpt.get();
			populacaoExistente.setQtd(populacao.getQtd());
			populacao = populacaoExistente;
		}
		populacao.setClassificacao(classificacao);
		populacaoRepository.save(populacao);
	}

	public void inserirPopulacoes(List<Populacao> populacoes) {
		for (Populacao populacao : populacoes) {
			inserirPopulacao(populacao);
		}
	}

}
