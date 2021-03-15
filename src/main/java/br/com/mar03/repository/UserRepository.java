package br.com.mar03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mar03.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
