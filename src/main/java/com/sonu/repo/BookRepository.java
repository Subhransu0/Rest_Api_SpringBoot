package com.sonu.repo;

import org.springframework.data.repository.CrudRepository;

import com.sonu.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	
	public Book findById(int id);

}
