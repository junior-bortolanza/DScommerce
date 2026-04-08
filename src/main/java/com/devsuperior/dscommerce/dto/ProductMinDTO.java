package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Category;
import com.devsuperior.dscommerce.entities.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

@Schema(description = "DTO responsável por representar uma visão resumida de um produto")
public class ProductMinDTO {
    @Schema(description = "Identificador único do produto", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Descrição do produto", example = "PC Gamer com 32GB de RAM, SSD DE 512GB e processador Ryzen 7")
    private String name;

    @Schema(description = "Preço do produto", example = "2499.90")
    private Double price;

    @Schema(description = "URL da imagem do produto", example = "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg")
    private String imgUrl;

    @Schema(description = "Lista de categorias associadas ao produto")
    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductMinDTO() {
    }

    public ProductMinDTO(Long id, String name, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductMinDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
        for (Category cat : entity.getCategories()) {
            categories.add(new CategoryDTO(cat));
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}
