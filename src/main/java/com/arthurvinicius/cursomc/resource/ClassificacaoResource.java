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

import com.arthurvinicius.cursomc.domain.Classificacao;
import com.arthurvinicius.cursomc.repository.ClassificacaoRepository;

@RestController
@RequestMapping(value = "/master/classificacoes")
public class ClassificacaoResource {

	@Autowired
	ClassificacaoRepository classificacaoRepository;

	@GetMapping
	public ResponseEntity<List<?>> findAll() {
		return ResponseEntity.ok().body(classificacaoRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable String id) {
		return ResponseEntity.ok().body(classificacaoRepository.findById(id));
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Classificacao classificacao) {
		return ResponseEntity.ok().body(classificacaoRepository.save(classificacao));

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody Classificacao classificacao) {
		isPrest(id);
		return ResponseEntity.ok().body(classificacaoRepository.save(classificacao));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> classificacaoRepository(@PathVariable String id) {
		isPrest(id);
		classificacaoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	public void isPrest(String id) {
		if (!classificacaoRepository.findById(id).isPresent()) {

		}
	}
}
