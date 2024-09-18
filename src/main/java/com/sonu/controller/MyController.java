package com.sonu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sonu.entity.Book;
import com.sonu.services.BookService;

@RestController
public class MyController {
	 @Autowired
	    private BookService bookService;

	    // Get ALL Books
	    @GetMapping("/books")
	    public ResponseEntity<List<Book>> getBooks() {
	        List<Book> list = bookService.getAllBooks();
	        if (list.size() <= 0) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	        return ResponseEntity.ok(list);
	    }

	    // Get Single Book By Id
	    @GetMapping("/books/{id}")
	    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
	        Book book = bookService.getBookById(id);
	        if (book == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	        return ResponseEntity.ok(book);
	    }

	    // Create or Add Or new Book handler
	    @PostMapping("/books")
	    public ResponseEntity<Book> addBook(@RequestBody Book book) {
	        if (book == null) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	        }
	        try {
	            Book b = this.bookService.addBook(book);
	            return ResponseEntity.status(HttpStatus.CREATED).build();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }

	    }

	    // Delete Book Handler
	    @DeleteMapping("/books/{id}")
	    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
	        try {
	            this.bookService.deleteBook(id);
	            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

	        }
	    }

	    // Delete All Books
	    @DeleteMapping("/books")
	    public ResponseEntity<Void> deleteAllBookks() {
	        try {
				this.bookService.deleteAllBooks();
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
	    }

	    // Update Books Handler
	    @PutMapping("/books/{id}")
	    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") int id) {
	        try {
	            this.bookService.updatedBook(book, id);
	            return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
	        } catch (Exception e) {

	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }

	    }
}
