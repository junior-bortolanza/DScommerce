package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.OrderItem;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO responsável por representar um item do pedido")
public class OrderItemDTO {

    @Schema(description = "Identificador único do produto associado ao item", example = "1")
    private Long productId;

    @Schema(description = "Nome do produto associado ao item", example = "Notebook Gamer")
    private String name;

    @Schema(description = "Preço unitário do produto no momento da compra", example = "1999.90")
    private Double price;

    @Schema(description = "Quantidade do produto no pedido", example = "2")
    private Integer quantity;

    @Schema(description = "URL da imagem do produto", example = "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg")
    private String imgUrl;

    public OrderItemDTO(Long productId, String name, Double price, Integer quantity, String imgUrl) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imgUrl = imgUrl;
    }

    public OrderItemDTO(OrderItem entity) {
        productId = entity.getProduct().getId();
        name = entity.getProduct().getName();
        price = entity.getPrice();
        quantity = entity.getQuantity();
        imgUrl = entity.getProduct().getImgUrl();
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getSubTotal() {
        return price * quantity;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
