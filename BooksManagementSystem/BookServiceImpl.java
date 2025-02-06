package com.example.BooksManagementSystem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public Book createBook(Book book) {
		
		return bookRepository.save(book);
	}

	@Override
	public List<Book> findAllBooks() {
		
		return bookRepository.findAll();
		}

	@Override
	public Optional<Book> findBookByID(String id) {
		
		return bookRepository.findById(id);
	}

	@Override
	public Book updateBook(String id, Book book) {
		Optional<Book> existingBook = bookRepository.findById(id);
		if(existingBook.isPresent()) {
			book.setId(id);
			return bookRepository.save(book);
		}else {
			throw new IllegalArgumentException("Invalid Book id "+id);
		}
	}

	@Override
	public void deleteBookByID(String id) {
		bookRepository.deleteById(id);
	}
	

}
