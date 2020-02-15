package com.arthurvinicius.cursomc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthurvinicius.cursomc.domain.Classificacao;
import com.arthurvinicius.cursomc.repository.ClassificacaoRepository;

@Service
public class ClassificacaoService {

	@Autowired
	ClassificacaoRepository repo;
	
	public List<Classificacao> findAll(){
		return repo.findAll();
	}

	
}
