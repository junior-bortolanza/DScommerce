package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Category;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO responsável por apresenta uma categoria")
public class CategoryDTO {

	@Schema(description = "Identificador único da categoria", example = "2")
	private Long id;
	@Schema(description = "Nome da categoria", example = "Notebook")
	private String name;
	
	public CategoryDTO() {
	}
	
	public CategoryDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public CategoryDTO(Category entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
