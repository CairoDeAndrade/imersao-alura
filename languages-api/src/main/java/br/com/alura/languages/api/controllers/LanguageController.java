package br.com.alura.languages.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.languages.api.entities.Language;
import br.com.alura.languages.api.repositories.LanguageRepository;

@RestController
public class LanguageController {
	
	@Autowired
	private LanguageRepository repository;
	
	@GetMapping("/languages")
	public ResponseEntity<List<Language>> findAll() {
		List<Language> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
}
