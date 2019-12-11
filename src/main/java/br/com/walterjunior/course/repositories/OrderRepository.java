package br.com.walterjunior.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.walterjunior.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
