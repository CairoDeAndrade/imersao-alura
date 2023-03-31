package br.com.alura.languages.api.entities;

import java.util.Objects;

public class Language {
	
	private Long id;
	private String name;
	private String imageUrl;
	private Integer rankPosition;
	
	public Language() {
	}

	public Language(String name, String imageUrl, Integer rankPosition) {
		super();
		this.name = name;
		this.imageUrl = imageUrl;
		this.rankPosition = rankPosition;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getRankPosition() {
		return rankPosition;
	}

	public void setRankPosition(Integer rankPosition) {
		this.rankPosition = rankPosition;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Language other = (Language) obj;
		return Objects.equals(id, other.id);
	}
}
