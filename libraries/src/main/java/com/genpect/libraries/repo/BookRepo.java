package com.genpect.libraries.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genpect.libraries.entity.BooksEntity;

@Repository
public interface BookRepo extends JpaRepository<BooksEntity, Integer>{

}
