package com.example.spring_jdbc.service;

import com.example.spring_jdbc.dto.BookDto;
import com.example.spring_jdbc.persistien.Book;
import com.example.spring_jdbc.persistien.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    BookRepository repository;

    public Book getBookByTitle(String title){
        if (repository.getBookByTitle(title).isPresent()){
            return repository.getBookByTitle(title).get();
        }
        else{
            System.out.println("no book");
            return null;
        }
    }

    public void saveBook(BookDto bookDto){
        if (repository.getBookByTitle(bookDto.getTitle()).isEmpty()){
            Book book = new Book();
            book.setTitle(bookDto.getTitle());
            book.setAuthor(bookDto.getAuthor());
            book.setPublicationYear(bookDto.getPublicationYear());
        }
        else {
            System.out.println("book is present");
        }
    }

    public Book updateBook(BookDto bookDto){
        Book book = repository.findById(bookDto.getId()).orElse(null);
        if (book!=null){
            book.setTitle(bookDto.getTitle());
            book.setAuthor(bookDto.getAuthor());
            book.setPublicationYear(bookDto.getPublicationYear());
        }
        return book;
    }

    public void deleteBook(String title){
        repository.deleteBookByTitle(title);
    }

}
