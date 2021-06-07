package com.example.BookDemo.service;

import com.example.BookDemo.Entirty.Library;
import com.example.BookDemo.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryService {
    @Autowired
    LibraryRepository libraryRepository;

    public String buildId(String  isbn,int aisle)
    {
        if(isbn.startsWith("Z"))
        {
            return "OLD"+isbn+aisle;
        }
        else
        return isbn+aisle;
    }

    public boolean checkBookAlredyExist(String id){
            Optional<Library>lib=libraryRepository.findById(id);
            if (lib.isPresent())
                return true;
            else
            return false;
    }
}
