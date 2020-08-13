package com.genpect.libraries.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="library")
public class LibraryEntity {
	
	@Id
	private String libraryName;
	
	@OneToMany(mappedBy = "libraryName")
	private List<BooksEntity> books;
	
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public List<BooksEntity> getBooks() {
		return books;
	}
	public void setBooks(List<BooksEntity> books) {
		this.books = books;
	}
}
