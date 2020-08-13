package com.genpect.libraries.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genpect.libraries.entity.LibraryEntity;

@Repository
public interface LibraryRepo extends JpaRepository<LibraryEntity, String>{

}
