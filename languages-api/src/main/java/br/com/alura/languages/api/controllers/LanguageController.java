package br.com.alura.languages.api.controllers;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.alura.languages.api.dto.LanguageDTO;
import br.com.alura.languages.api.entities.Language;
import br.com.alura.languages.api.services.LanguageService;

@RestController
@RequestMapping("/languages")
public class LanguageController {
	
	@Autowired
	private LanguageService service;
	
	@GetMapping
	public ResponseEntity<List<LanguageDTO>> findAll() {
		List<LanguageDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LanguageDTO> findById(@PathVariable String id) {
		LanguageDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<LanguageDTO> insert(@RequestBody Language language){
		
		LanguageDTO languageDTO = service.insert(language);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(languageDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(languageDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LanguageDTO> update(@PathVariable String id, @RequestBody Language newLanguage){
		LanguageDTO languageDTO = service.update(id, newLanguage);
		return ResponseEntity.ok().body(languageDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
