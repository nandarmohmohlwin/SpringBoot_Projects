package com.springboot.bsm.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "my_books")
public class MyBook {

	@Id
	private int id;
	private String name;
	private String author;
	private String price;
	
	public MyBook(String name, String author, String price) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
	}
	
	
}
