package com.example.BooksManagementSystem;

import java.util.List;
import java.util.Optional;

public interface BookService {
	
	Book createBook(Book book);
	
	List<Book> findAllBooks();
	
	Optional<Book> findBookByID(String id);
	
	Book updateBook(String id, Book book);
	
	void deleteBookByID(String id);

}
