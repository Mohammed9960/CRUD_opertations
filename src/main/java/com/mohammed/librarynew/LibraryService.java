package com.mohammed.librarynew;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class LibraryService {

    private final LibraryRepository repository;

    public List<LibraryManagementSystem> findAllBooks() {

        return repository.findAll();
    }
    public LibraryManagementSystem findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("not found"));
    }

    public List<LibraryManagementSystem> findAllByAuthor(String author){

        return repository.findAllByAuthorContainsIgnoreCase(author);

    }

    public LibraryManagementSystem findByBookName(String name) {
        return repository.findByBookContains(name);
    }

    public void addBook(LibraryManagementSystem library){
         repository.save(library);
    }


    public void deleteById(Integer id) {

        if(!repository.existsById(id)) {
            throw new EntityNotFoundException("Not found");
        }
        repository.deleteById(id);
    }

    public ResponseEntity<LibraryManagementSystem> updateBookVersion
            (Integer id , LibraryManagementSystem updated){



        LibraryManagementSystem toBeUpdated = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("not found"));

        toBeUpdated.setBookVersion(updated.getBookVersion());
        repository.save(toBeUpdated);

        return ResponseEntity.ok(toBeUpdated);


    }


}
