package com.example.BookDemo.repository;

import com.example.BookDemo.Entirty.Library;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class LibraryRepositoryImpl implements LibraryRepositoryCustom{
    @Autowired
    LibraryRepository libraryRepository;
    public List<Library> findAllByAuthor(String authorName) {
        List<Library> bookswithAuthor = new ArrayList<>();

        List<Library> books = libraryRepository.findAll();
        for (Library item : books) {
            if (item.getAuthor().equalsIgnoreCase(authorName))
            {
                bookswithAuthor.add(item);
            }
        }
        return bookswithAuthor;
    }
}
