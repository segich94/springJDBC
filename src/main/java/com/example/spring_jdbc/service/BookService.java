package com.example.spring_jdbc.service;

import com.example.spring_jdbc.dto.BookDto;
import com.example.spring_jdbc.persistien.Book;
import com.example.spring_jdbc.persistien.BookDao;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    BookDao repository;

    public Book getBookByTitle(String title){
        return repository.getBookByTitle(title);
    }

    public void saveBook(BookDto bookDto){
        repository.getBookByTitle(bookDto.getTitle());


    }

    public void updateBook(BookDto bookDto){
        repository.getBookByTitle(bookDto.getTitle());

    }

    public void deleteBook(String title){
        repository.deleteBookByTitle(title);
    }

}
