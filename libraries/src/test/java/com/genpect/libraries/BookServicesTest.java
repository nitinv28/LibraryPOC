package com.genpect.libraries;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.genpect.libraries.entity.BooksEntity;
import com.genpect.libraries.repo.BookRepo;
import com.genpect.libraries.services.BookServices;

@RunWith(MockitoJUnitRunner.class)
public class BookServicesTest {
	
	@InjectMocks BookServices bookServices;
	@Mock BookRepo bookRepo;
	
	@Test
	public void saveBooksTest(){
		BooksEntity be = new BooksEntity();
		Mockito.when( bookRepo.save(be)).thenReturn(be);
		BooksEntity allBooks = bookServices.saveBooks(be);
		Assert.assertNotNull(allBooks);
	}
	
	@Test
	public void updateBooksTest(){
		BooksEntity be = new BooksEntity();
		be.setId(1);
		Mockito.when( bookRepo.save(be)).thenReturn(be);
		
		Optional<BooksEntity> op = Optional.ofNullable(be);
		Mockito.when(bookRepo.findById(1)).thenReturn(op);
		
		BooksEntity allBooks = bookServices.updateBooks(be);
		Assert.assertNotNull(allBooks);
	}
	
	@Test
	public void getAllBooks(){
		BooksEntity be = new BooksEntity();
		List<BooksEntity> bookList = new ArrayList<BooksEntity>();
		bookList.add(be);
		Mockito.when( bookRepo.findAll()).thenReturn(bookList);
		List<BooksEntity> allBooks = bookServices.getAllBooks();
		Assert.assertNotNull(allBooks);
	}
	
	@Test
	public void getBookByIdTest(){
		BooksEntity be = new BooksEntity();
		be.setId(1);
		
		Optional<BooksEntity> op = Optional.ofNullable(be);
		Mockito.when(bookRepo.findById(1)).thenReturn(op);
		
		BooksEntity bookById = bookServices.getBookById(1);
		Assert.assertNotNull(bookById);
	}

}
