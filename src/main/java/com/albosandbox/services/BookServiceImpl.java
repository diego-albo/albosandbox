package com.albosandbox.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.albosandbox.models.Book;
import com.albosandbox.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService
{
	@Autowired
	private BookRepository bookRepository;

    public Boolean saveBook(Book book)
    {
    	Boolean banderaReturn = false;

        try
        {
        	bookRepository.save(book);
        	banderaReturn = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return banderaReturn;
    }

    public Iterable<Book> findBooks()
    {
    	Iterable<Book> books = new ArrayList<Book>();

        try
        {
        	books = bookRepository.findAll();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return books;
    }

    public Optional<Book> findBookById(Long id)
    {
    	Optional<Book> book = null;

        try
        {
        	book = bookRepository.findById(id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return book;
    }

    public Boolean updateBookById(Long id, Book newBook)
    {
    	Boolean banderaReturn = false;

        try
        {
        	bookRepository.findById(id)
			.map(book -> {
				book.setAuthor(newBook.getAuthor());
				book.setTitle(newBook.getTitle());
				book.setYear(newBook.getYear());

				return bookRepository.save(book);
			})
			.orElseGet(() -> {
				newBook.setId(id);

				return bookRepository.save(newBook);
			});

        	banderaReturn = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return banderaReturn;
    }

    public Boolean deleteBooks()
    {
    	Boolean banderaReturn = false;

        try
        {
        	bookRepository.deleteAll();
        	banderaReturn = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return banderaReturn;
    }

    public Boolean deleteBookById(Long id)
    {
    	Boolean banderaReturn = false;

        try
        {
        	bookRepository.deleteById(id);
        	banderaReturn = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return banderaReturn;
    }
}
