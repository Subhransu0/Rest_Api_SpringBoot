package com.sonu.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sonu.entity.Book;
import com.sonu.repo.BookRepository;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	// private static List<Book> list = new ArrayList<>();
//    static {
//        list.add(new Book(12, "Java", "Subhransu"));
//        list.add(new Book(13, "Python", "Sonu"));
//        list.add(new Book(14, "Full Stack", "Mohan"));
//    }

	// Get All Book
	public List<Book> getAllBooks() {
   List<Book> list = (List<Book>)this.bookRepository.findAll();
    	return list;
    }

	// get Single BOOK by id
	public Book getBookById(int id) {
		Book book = this.bookRepository.findById(id);
		return book;
		
	}

	// adding the book
	public Book addBook(Book b) {
		Book book = bookRepository.save(b);
		return book;
	}

	// Delete Single Book By id
	public void deleteBook(int bid) {
		// Book book = null;
		// book = list.stream().filter(e -> e.getId() == bid).findFirst().get();
		// list.remove(book);
		// System.out.println("Book Delete SuccessFully" + book);

//		list.removeIf(b -> b.getId() == bid);

		bookRepository.deleteById(bid);
	}

	// delete All Books
	public void deleteAllBooks() {
		bookRepository.deleteAll();
	}

	// Update Book By Id
	public void updatedBook(Book book, int id) {

//		list.stream().filter(b -> b.getId() == id).findFirst().ifPresent(b -> {
//			b.setAuthor(book.getAuthor());
//			b.setTitle(book.getTitle());
//		});

		book.setId(id);

		bookRepository.save(book);

	}

}