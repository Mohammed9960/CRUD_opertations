package com.mohammed.librarynew;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/library")
public class LibraryController {
    private final LibraryService service;


    @PostMapping
    public void addBook(@RequestBody LibraryManagementSystem library) {
         service.addBook(library);
    }

    @GetMapping
    public List<LibraryManagementSystem> findAll() {

        return service.findAllBooks();
    }

    @GetMapping("find-author/{name}")
    public List<LibraryManagementSystem> findByAuthor(@PathVariable("name") String name) {

        return service.findAllByAuthor(name);
    }

    @GetMapping("/{id}")
    public LibraryManagementSystem findById(@PathVariable Integer id ){
        return service.findById(id);
    }

    @GetMapping("/find-name/{name}")
    public LibraryManagementSystem findByName(@PathVariable("name") String name){

        return service.findByBookName(name);


    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id ){
        service.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<LibraryManagementSystem> updateBookVersion
            (@PathVariable("id") Integer id ,@RequestBody LibraryManagementSystem library){

         service.addBook(library);

         return ResponseEntity.ok(library);
    }

}
