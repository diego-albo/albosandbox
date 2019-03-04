package com.albosandbox.repositories;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import com.albosandbox.models.Book;

public interface BookRepository extends DatastoreRepository<Book, Long>
{
	/*
	List<Book> findByAuthor(String author);
	List<Book> findByYearGreaterThan(int year);
	List<Book> findByAuthorAndYear(String author, int year);
	*/
}
