package br.com.alura.languages.api.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mainLanguages")
public class Language {
	
	@Id
	private String id;
	private String name;
	private String image;
	private Integer ranking;
	
	public Language() {
	}

	public Language(String name, String image, Integer ranking) {
		super();
		this.name = name;
		this.image = image;
		this.ranking = ranking;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}
}
