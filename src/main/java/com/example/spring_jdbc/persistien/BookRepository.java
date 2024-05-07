package com.example.spring_jdbc.persistien;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> getBookByTitle(String title);
    void deleteBookByTitle(String title);
}
