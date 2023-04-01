package br.com.alura.languages.api.dto;

import br.com.alura.languages.api.entities.Language;

public class LanguageDTO {
	
	private String id;
	private String name;
	private String image;
	private Integer ranking;
	
	public LanguageDTO() {
	}

	public LanguageDTO(String id, String name, String image, Integer ranking) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.ranking = ranking;
	}
	
	public LanguageDTO(Language entity) {
		id = entity.getId();
		name = entity.getName();
		image = entity.getImage();
		ranking = entity.getRanking();
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
