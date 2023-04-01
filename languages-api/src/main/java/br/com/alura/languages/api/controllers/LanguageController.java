package br.com.alura.languages.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.languages.api.dto.LanguageDTO;
import br.com.alura.languages.api.entities.Language;
import br.com.alura.languages.api.services.LanguageService;

@RestController
public class LanguageController {
	
	@Autowired
	private LanguageService service;
	
	@GetMapping("/languages")
	public ResponseEntity<List<LanguageDTO>> findAll() {
		List<LanguageDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/languages")
	public ResponseEntity<LanguageDTO> insert(@RequestBody Language language){
		LanguageDTO languageDTO = service.insert(language);
		return ResponseEntity.ok().body(languageDTO);
	}
}
