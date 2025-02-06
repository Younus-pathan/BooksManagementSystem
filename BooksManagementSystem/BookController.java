package com.example.BooksManagementSystem;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookInfo")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		Book createdBook =bookService.createBook(book);
		return new ResponseEntity<Book>(createdBook,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> findAllBooks(){
		List<Book> bookList =bookService.findAllBooks();
		return ResponseEntity.ok(bookList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> findBookById(@PathVariable String id){
		Optional<Book> book =bookService.findBookByID(id);
		if(book.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
					
		}else {
			return  ResponseEntity.ok(book.get());
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable String id,@RequestBody Book book){
		Book updatedBook =bookService.updateBook(id, book);
		if(Objects.nonNull(updatedBook)) {
			return ResponseEntity.ok(updatedBook);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookByID(@PathVariable String id){
		bookService.deleteBookByID(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
