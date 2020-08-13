package com.genpect.libraries.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.genpect.libraries.entity.BooksEntity;
import com.genpect.libraries.exception.CustomException;
import com.genpect.libraries.repo.BookRepo;

@Service
public class BookServices {
	@Autowired BookRepo bookRepo;

	public BooksEntity saveBooks(BooksEntity booksEntity){
		return bookRepo.save(booksEntity);
	}
	
	public BooksEntity updateBooks(BooksEntity booksEntity){
		if(!bookRepo.findById(booksEntity.getId()).isPresent()){
			throw new CustomException("book ID is invalid", HttpStatus.NOT_FOUND);
		}
		return bookRepo.save(booksEntity);
	}
	
	public List<BooksEntity> getAllBooks(){
		return bookRepo.findAll();
	}
	
	public BooksEntity getBookById(int id){
		return bookRepo.findById(id).get();
	}
}
