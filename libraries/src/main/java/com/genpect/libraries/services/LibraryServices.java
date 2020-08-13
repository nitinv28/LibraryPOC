package com.genpect.libraries.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.genpect.libraries.entity.LibraryEntity;
import com.genpect.libraries.exception.CustomException;
import com.genpect.libraries.repo.LibraryRepo;

@Service
public class LibraryServices {
	
	@Autowired LibraryRepo libraryRepo;
	
	public List<LibraryEntity> getLibraries() {
		return libraryRepo.findAll();
	}
	
	public LibraryEntity getLibraries(String id) {
		if(libraryRepo.findById(id).isPresent()) {
			return libraryRepo.findById(id).get();
		}
		else {
			throw new CustomException("Library ID is invalid", HttpStatus.NOT_FOUND);
		}
		
	}
}
