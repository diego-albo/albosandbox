package com.albosandbox.services;

import java.util.Optional;
import com.albosandbox.models.Book;

public interface BookService
{
	public Boolean saveBook(Book book);
	public Iterable<Book> findBooks();
	public Optional<Book> findBookById(Long id);
	public Boolean updateBookById(Long id, Book newBook);
	public Boolean deleteBooks();
	public Boolean deleteBookById(Long id);
}
