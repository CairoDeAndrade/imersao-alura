package br.com.alura.languages.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.languages.api.entities.Language;

@Repository
public interface LanguageRepository extends MongoRepository<Language, String>{

}
