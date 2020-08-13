package com.genpect.libraries;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.genpect.libraries.controller.Controller;
import com.genpect.libraries.entity.BooksEntity;
import com.genpect.libraries.entity.LibraryEntity;
import com.genpect.libraries.services.BookServices;
import com.genpect.libraries.services.LibraryServices;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

	@InjectMocks Controller controller;
	@Mock LibraryServices libraryServices;  
	@Mock BookServices bookServices;
	
	@Test
	public void getLibrariesTest() {
		LibraryEntity be = new LibraryEntity();
		List<LibraryEntity> libraryList = new ArrayList<LibraryEntity>();
		libraryList.add(be);
		Mockito.lenient().when(libraryServices.getLibraries()).thenReturn(libraryList);
		List<LibraryEntity> libraries = controller.getLibraries();
		Assert.assertNotNull(libraries);
	}
	
	@Test
	public void getBooksTest() {
		BooksEntity be = new BooksEntity();
		List<BooksEntity> bookList = new ArrayList<BooksEntity>();
		
		bookList.add(be);
		Mockito.when( bookServices.getAllBooks()).thenReturn(bookList);
		List<BooksEntity> allBooks = controller.getAllBooks();
		Assert.assertNotNull(allBooks);
	}
	
	@Test
	public void getBooksOneTest() {
		BooksEntity be = new BooksEntity();
		Mockito.when(bookServices.getBookById(1)).thenReturn(be);
		BooksEntity books = controller.getBooks(1);
		Assert.assertNotNull(books);
	}
	
	@Test
	public void saveBookTest() {
		Mockito.when(bookServices.saveBooks(Mockito.any())).thenReturn(Mockito.any());
		BooksEntity be =new BooksEntity();
		controller.saveBook(be);
		Assert.assertNotNull(be);
		 
	}
}
