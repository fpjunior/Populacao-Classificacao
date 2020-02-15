package com.arthurvinicius.cursomc.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthurvinicius.cursomc.Dto.PopulacaoDto;
import com.arthurvinicius.cursomc.domain.Populacao;
import com.arthurvinicius.cursomc.repository.ClassificacaoRepository;
import com.arthurvinicius.cursomc.repository.PopulacaoRepository;
import com.arthurvinicius.cursomc.service.PopulacaoService;

@RestController
@RequestMapping(value = "/master/populacoes")
public class PopulacaoResource {

	@Autowired
	PopulacaoRepository populacaoRepository;

	@Autowired
	ClassificacaoRepository classificacaoRepository;
	
	@Autowired
	PopulacaoService populacaoService;
	
	@GetMapping
	public ResponseEntity<List<?>> findAll() {
		return ResponseEntity.ok().body(populacaoRepository.findAll());
	}



	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(populacaoRepository.findById(id));
	}

	@PostMapping
	public ResponseEntity<PopulacaoDto> save(@RequestBody PopulacaoDto populacaoDto) {
		populacaoService.inserirPopulacoes(populacaoDto.toObject());
		return ResponseEntity.ok().body(populacaoDto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Populacao populacao) {
		isPrest(id);
		return ResponseEntity.ok().body(populacaoRepository.save(populacao));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		isPrest(id);
		populacaoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	public void isPrest(Integer id) {
		if (!populacaoRepository.findById(id).isPresent()) {

		}
	}
}
