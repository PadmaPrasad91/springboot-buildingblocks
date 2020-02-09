package com.myapp.springbootrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.springbootrest.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
