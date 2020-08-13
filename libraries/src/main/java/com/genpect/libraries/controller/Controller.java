package com.genpect.libraries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.genpect.libraries.entity.BooksEntity;
import com.genpect.libraries.entity.LibraryEntity;
import com.genpect.libraries.services.BookServices;
import com.genpect.libraries.services.LibraryServices;

@CrossOrigin
@RestController
public class Controller {

	@Autowired LibraryServices libraryServices;  
	@Autowired BookServices bookServices;
	
	@GetMapping("/library")
	public List<LibraryEntity> getLibraries() {
		return libraryServices.getLibraries();
	}
	@GetMapping("/library/{id}")
	public LibraryEntity getLibraries(@PathVariable("id")String id) {
		return libraryServices.getLibraries(id);
	}
	
	@GetMapping("/books")
	public List<BooksEntity> getAllBooks() {
		return bookServices.getAllBooks();
	}
	
	@GetMapping("/books/{id}")
	public BooksEntity getBooks(@PathVariable("id")int id) {
		return bookServices.getBookById(id);
	}
	
	@PostMapping("/books")
	public BooksEntity saveBook(@RequestBody BooksEntity booksEntity) {
		return bookServices.saveBooks(booksEntity);
	}
	
	@PutMapping("/books")
	public BooksEntity updateBook(@RequestBody BooksEntity booksEntity) {
		return bookServices.updateBooks(booksEntity);
	}
}
