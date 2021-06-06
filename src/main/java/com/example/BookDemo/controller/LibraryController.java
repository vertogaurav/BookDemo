package com.example.BookDemo.controller;

import com.example.BookDemo.Entirty.Library;
import com.example.BookDemo.repository.LibraryRepository;
import com.example.BookDemo.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    LibraryRepository libraryRepository;
    @Autowired
    LibraryService libraryService;
    @PostMapping("/addBook")
    public ResponseEntity  addBook(@RequestBody Library library)
    {

        String id=libraryService.buildId(library.getIsbn(),library.getAisle());
        library.setId(id);
        AddResponse addResponse = new AddResponse();
        if(!libraryService.checkBookAlredyExist(id)) {

            libraryRepository.save(library);
            addResponse.setMsg("Sucess Book Is Added");
            addResponse.setId(library.getId());
            return new ResponseEntity(addResponse, HttpStatus.CREATED);
        }
        else {
            addResponse.setMsg("That Book Already Exist");
            addResponse.setId(id);
            return new ResponseEntity(addResponse,HttpStatus.ACCEPTED);
        }
    }
    @GetMapping("/books")
    public List<Library> books()
    {
        return libraryRepository.findAll();
    }

    @GetMapping("/book/{id}")
    public Library getBookById(@PathVariable(value = "id")String id)
    {
        try {
            Library lib = libraryRepository.findById(id).get();
            return lib;
        }
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book/{author}")
    public List<Library> getBookByAuthor(@RequestParam(value = "author")String author)
    {
                  return  libraryRepository.findAllByAuthor(author);
    }
    @PutMapping("/updateBook/{id}")
    public ResponseEntity<Library> updateBook(@PathVariable(value = "id") String id, @RequestBody Library library)
    {
        Library existingBook =libraryRepository.findById(id).get();

        existingBook.setAisle(library.getAisle());
        existingBook.setAuthor(library.getAuthor());
        existingBook.setBook_name(library.getBook_name());
        libraryRepository.save(existingBook);
        return new ResponseEntity<Library>(existingBook,HttpStatus.OK);

    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity<String > deleteBookById(@RequestBody Library library)
    {
        Library library1=libraryRepository.findById(library.getId()).get();
        libraryRepository.delete(library1);
        return  new ResponseEntity<>("Book is Deleted",HttpStatus.CREATED);
    }
}
