package com.devsuperior.dscommerce.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.devsuperior.dscommerce.entities.Category;
import com.devsuperior.dscommerce.entities.Product;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Schema(description = "DTO que representa um produto")
public class ProductDTO {

    @Schema(description = "Identificador único do produto", example = "3")
    private Long id;

    @Schema(description = "Nome do produto", example = "PC Gamer")
    @Size(min = 3, max = 80, message = "Nome precisar ter de 3 a 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;

    @Schema(description = "Descrição do produto", example = "PC Gamer com 32GB de RAM, SSD DE 512GB e processador Ryzen 7")
    @Size(min = 10, message = "Descrição precisa ter no mínimo 10 caracteres")
    @NotBlank(message = "Campo requerido")
    private String description;

    @Schema(description = "Preço do produto", example = "5999.00")
    @NotNull(message = "Campo requerido")
    @Positive(message = "O preço deve ser positivo")
    private Double price;

    @Schema(description = "URL da imagem do produto", example = "https://www.amazon.com.br/PC-Gamer-Preto-Ryzen-5700G/dp/B0G1QZ4GFQ/ref=asc_df_B0G1QZ4GFQ?mcid=1584037bf0b63963b8bc2de52abb065f&hvadid=709884378370&hvpos=&hvnetw=g&hvrand=6770785236769273323&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9100722&hvtargid=pla-2511686619007&psc=1&hvocijid=6770785236769273323-B0G1QZ4GFQ-&hvexpln=0&language=pt_BR")
    private String imgUrl;

    @Schema(description = "Lista de categorias associadas ao produto")
    @NotEmpty(message = "Deve ter pelo menos uma categoria")
    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
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

    public String getDescription() {
        return description;
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
