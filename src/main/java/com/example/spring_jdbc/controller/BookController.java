package com.example.spring_jdbc.controller;

import com.example.spring_jdbc.dto.BookDto;
import com.example.spring_jdbc.persistien.Book;
import com.example.spring_jdbc.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PutMapping("/newbook")
    public ResponseEntity<?> addNewBook(@RequestBody BookDto bookDto){
        bookService.saveBook(bookDto);
        return ResponseEntity.ok().body("OK");
    }
    @GetMapping("/updatebook")
    public ResponseEntity<?> updateBook(@RequestBody BookDto bookDto){
        bookService.updateBook(bookDto);
        return ResponseEntity.ok().body("OK");
    }
    @GetMapping("/book")
    public ResponseEntity<Book> getBook(@RequestBody String title){

        return ResponseEntity.ok().body(bookService.getBookByTitle(title));
    }
    @DeleteMapping("/delbook")
    public ResponseEntity<?> deleteBook(@RequestBody String title){
        bookService.deleteBook(title);
        return ResponseEntity.ok().body("deleted");
    }
}
