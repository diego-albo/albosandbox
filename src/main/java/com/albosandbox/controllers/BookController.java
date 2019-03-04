package com.albosandbox.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.albosandbox.models.Book;
import com.albosandbox.services.BookService;

@RestController
@RequestMapping(path = "/library")
public class BookController
{
	@Autowired
    private BookService bookService;

	@PostMapping
	(
		value = "/book",
		consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
		produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
		// headers = { "quantity=3" }
	)
	public ResponseEntity<Boolean> saveBook(@RequestBody Book book)
	{
		return ResponseEntity.ok(this.bookService.saveBook(book));
	}

	@GetMapping(value = "/books")
	public ResponseEntity<Iterable<Book>> findBooks()
	{
		return ResponseEntity.ok(this.bookService.findBooks());
	}

	@GetMapping(value = "/book/{id}")
	public ResponseEntity<Optional<Book>> findBookById(@PathVariable Long id)
	{
		return ResponseEntity.ok(this.bookService.findBookById(id));
	}

	@PutMapping
	(
		value = "/book/{id}",
		consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
		produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
	)
	public ResponseEntity<Boolean> updateBook(@PathVariable Long id, @RequestBody Book newBook)
	{
		return ResponseEntity.ok(this.bookService.updateBookById(id, newBook));
	}

	@DeleteMapping(value = "/books")
	public ResponseEntity<Boolean> deleteBooks()
	{
		return ResponseEntity.ok(this.bookService.deleteBooks());
	}

	@DeleteMapping(value = "/book/{id}")
	public ResponseEntity<Boolean> deleteBook(@PathVariable Long id)
	{
		return ResponseEntity.ok(this.bookService.deleteBookById(id));
	}
}
