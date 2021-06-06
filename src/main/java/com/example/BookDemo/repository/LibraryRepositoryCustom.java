package com.example.BookDemo.repository;

import com.example.BookDemo.Entirty.Library;

import java.util.List;

public interface LibraryRepositoryCustom {
    List<Library> findAllByAuthor(String authorName);
}
