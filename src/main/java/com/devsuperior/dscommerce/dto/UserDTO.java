package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.User;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO dos usuarios do sistemas")
public class UserDTO {
    @Schema(description = "Identificador único do usuário", example = "1")
    private Long id;
    @Schema(description = "Nome do usuário", example = "Junior Bortolanza")
    private String name;

    public UserDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserDTO(User entity) {
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
