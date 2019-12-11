package br.com.walterjunior.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.walterjunior.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
