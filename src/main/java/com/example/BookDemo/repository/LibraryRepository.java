package com.example.BookDemo.repository;

import com.example.BookDemo.Entirty.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library,String >,LibraryRepositoryCustom {

}
