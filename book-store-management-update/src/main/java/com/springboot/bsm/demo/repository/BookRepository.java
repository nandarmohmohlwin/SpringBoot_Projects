package com.springboot.bsm.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bsm.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
