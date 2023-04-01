package br.com.alura.languages.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.languages.api.dto.LanguageDTO;
import br.com.alura.languages.api.entities.Language;
import br.com.alura.languages.api.repositories.LanguageRepository;
import br.com.alura.languages.api.services.exceptions.DatabaseException;
import br.com.alura.languages.api.services.exceptions.ResourceNotFoundException;

@Service
public class LanguageService {
	
	@Autowired
	private LanguageRepository repository;
	
	@Transactional(readOnly = true)
	public List<LanguageDTO> findAll() {
		List<Language> list = repository.findAll();
		return list.stream().map(obj -> new LanguageDTO(obj)).collect(Collectors.toList());
	}
	
	@Transactional
	public LanguageDTO insert(Language language) {
		Language entity = repository.save(language);
		return new LanguageDTO(entity);
	}
	
	public void delete(String id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
}
