package com.role.implementation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.role.implementation.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String emailId);
}
