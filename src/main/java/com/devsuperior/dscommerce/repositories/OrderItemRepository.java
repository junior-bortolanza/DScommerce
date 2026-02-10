package com.devsuperior.dscommerce.repositories;
import com.devsuperior.dscommerce.entities.OrdemItemPK;
import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrdemItemPK>
{}
