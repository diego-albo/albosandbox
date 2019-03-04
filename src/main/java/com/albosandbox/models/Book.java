package com.albosandbox.models;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity(name = "books")
public class Book
{
	@Id
    Long id;
    String title;
    String author;
    int year;

	public Book() {}

	public Book(String title, String author, int year)
    {
    	this.title = title;
        this.author = author;
        this.year = year;
	}

    public Long getId()
    {
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}
}
