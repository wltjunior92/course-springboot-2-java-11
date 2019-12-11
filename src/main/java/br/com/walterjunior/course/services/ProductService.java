package br.com.walterjunior.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.walterjunior.course.entities.Product;
import br.com.walterjunior.course.repositories.ProductRepository;
import br.com.walterjunior.course.services.exceptions.DatabaseException;
import br.com.walterjunior.course.services.exceptions.ResourceNotFoundEsception;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = productRepository.findById(id);
		return obj.get();
	}
	
	public Product insert(Product product) {
		return productRepository.save(product);
	}
	
	public void delete(Long id) {
		try {
			productRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundEsception(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Product update(Long id, Product product) {
		try {
			Product entity = productRepository.getOne(id);
			updateData(entity, product);
			return productRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundEsception(id);
		}
	}

	private void updateData(Product entity, Product product) {
		entity.setName(product.getName());
		entity.setDescription(product.getDescription());
		entity.setPrice(product.getPrice());
		entity.setImgUrl(product.getImgUrl());
	}
}
