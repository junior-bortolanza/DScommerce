package com.devsuperior.dscommerce.dto;
import com.devsuperior.dscommerce.entities.Payment;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;

@Schema(description = "DTO responsavel por representar um pagamento ", example = "1")
public class PaymentDTO {

    @Schema(description = "Identificador único do pagamento", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Data e hora em que o pagamento foi realizado", example = "2026-04-03T14:30:00Z", accessMode = Schema.AccessMode.READ_ONLY)
    private Instant moment;

    public PaymentDTO(Long id, Instant moment) {
       this.id = id;
       this.moment = moment;
    }

    public PaymentDTO(Payment entity) {
      id = entity.getId();
      moment = entity.getMoment();
    }


    public Long getId() {
        return id;
    }
    public Instant getMoment() {
        return moment;
    }
}
