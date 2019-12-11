package br.com.walterjunior.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.walterjunior.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
