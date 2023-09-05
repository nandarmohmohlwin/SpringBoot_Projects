package com.springboot.bsm.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bsm.demo.entity.MyBook;

public interface MyBookRepository extends JpaRepository<MyBook, Integer> {

}
