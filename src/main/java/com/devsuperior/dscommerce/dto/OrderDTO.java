package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderItem;
import com.devsuperior.dscommerce.entities.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Schema(description = "DTO responsável por representar os pedidos")
public class OrderDTO {
    @Schema(description = "Identificador único do pedido", example = "1")
    private Long id;
    @Schema(description = "Data e hora em que o pedido foi realizado", example = "2026-04-02T15:30:00Z")
    private Instant moment;
    @Schema(description = "Status atual do pedido", example = "WAITING_PAYMENT")
    private OrderStatus status;
    @Schema(description = "Cliente responsável pelo pedido", example = "Alex Brun")
    private UserDTO user;
    @Schema(description = "Informações de pagamento associadas ao pedido")
    private PaymentDTO payment;

    @Schema(description = "Lista de itens do pedido. Deve conter pelo menos um item")
    @NotEmpty(message = "Deve ter pelo menos um Item")
    private List<OrderItemDTO> items = new ArrayList<>();

    public OrderDTO(Long id, Instant moment, OrderStatus status, UserDTO user, PaymentDTO payment) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.user = user;
        this.payment = payment;
    }

    public OrderDTO(Order entity) {
       id = entity.getId();
       moment = entity.getMoment();
       status = entity.getStatus();
       user = new UserDTO(entity.getClient());
       payment = (entity.getPayment() == null) ?  null : new PaymentDTO(entity.getPayment());
       for(OrderItem item : entity.getItems()){
           OrderItemDTO itemDto = new OrderItemDTO(item);
           items.add(itemDto);
       }
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public UserDTO getClient() {
        return user;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public Double getTotal() {
        double sum = 0.0;
        for (OrderItemDTO item : items) {
            sum += sum + item.getSubTotal();
        }
        return sum;
    }
}
