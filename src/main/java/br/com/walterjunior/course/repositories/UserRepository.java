package br.com.walterjunior.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.walterjunior.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
