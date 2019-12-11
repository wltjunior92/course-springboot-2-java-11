package br.com.walterjunior.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.walterjunior.course.entities.Order;
import br.com.walterjunior.course.repositories.OrderRepository;
import br.com.walterjunior.course.services.exceptions.DatabaseException;
import br.com.walterjunior.course.services.exceptions.ResourceNotFoundEsception;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = orderRepository.findById(id);
		return obj.get();
	}
	
	public Order insert(Order order) {
		return orderRepository.save(order);
	}
	
	public void delete(Long id) {
		try {
			orderRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundEsception(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Order update (Long id, Order order) {
		try {
			Order entity = orderRepository.getOne(id);
			dataUpdate(entity, order);
			return orderRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundEsception(id);
		}
	}

	private void dataUpdate(Order entity, Order order) {
		entity.setStatus(order.getStatus());
	}
}
