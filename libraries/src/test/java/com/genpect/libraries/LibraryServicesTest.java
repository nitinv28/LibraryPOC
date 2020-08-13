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

import com.genpect.libraries.entity.LibraryEntity;
import com.genpect.libraries.repo.LibraryRepo;
import com.genpect.libraries.services.LibraryServices;

@RunWith(MockitoJUnitRunner.class)
public class LibraryServicesTest {

	@InjectMocks LibraryServices libraryServices;
	@Mock LibraryRepo libraryRepo;

	@Test
	public void getLibrariesTest() {

		LibraryEntity be = new LibraryEntity();
		List<LibraryEntity> libraryList = new ArrayList<LibraryEntity>();
		libraryList.add(be);
		Mockito.lenient().when(libraryRepo.findAll()).thenReturn(libraryList);

		List<LibraryEntity> libraries = libraryServices.getLibraries();
		Assert.assertNotNull(libraries);
	}
	
	@Test
	public void getLibrariesByIdTest() {

		LibraryEntity be = new LibraryEntity();
		List<LibraryEntity> libraryList = new ArrayList<LibraryEntity>();
		libraryList.add(be);
		Mockito.lenient().when(libraryRepo.findAll()).thenReturn(libraryList);
		
		Optional<LibraryEntity> op = Optional.ofNullable(new LibraryEntity());
		Mockito.when(libraryRepo.findById("L01")).thenReturn(op);

		LibraryEntity libraries = libraryServices.getLibraries("L01");
		Assert.assertNotNull(libraries);
	}

}
