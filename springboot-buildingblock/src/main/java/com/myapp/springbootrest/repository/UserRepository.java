package com.myapp.springbootrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.springbootrest.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User getUserByUsername(String username);
}
