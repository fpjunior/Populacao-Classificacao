package com.arthurvinicius.cursomc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arthurvinicius.cursomc.domain.Populacao;

@Repository
public interface PopulacaoRepository extends JpaRepository<Populacao, Integer> {

	@Query("SELECT p FROM Populacao p WHERE p.ano = :ano AND p.cnes = :cnes AND p.classificacao.id = :classificaoId")
	public Optional<Populacao> findByAnoCnesClassificao(Integer ano, String cnes, String classificaoId);
	
}
