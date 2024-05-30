package com.example.spring_jdbc.persistien;

import com.example.spring_jdbc.dto.BookDto;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
@Repository
public class BookDao {
    private static final String URL = "jdbc:postgresql://localhost:5432/jdbc";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public DataSource myDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(myDataSource());


    public Book getBookByTitle(String title){
        return jdbcTemplate.queryForObject(
                "SELECT author title publication_year FROM _book WHERE title = ?",
                (resultSet, rowNum) ->{
                    Book newBook = Book.builder()
                            .title(resultSet.getString("title"))
                            .author(resultSet.getString("author"))
                            .publicationYear(resultSet.getInt("publication_year"))
                            .build();
                    return newBook;
                }, title
        );
    }

    public void updateBookByTitle(BookDto bookDto){
        String title = bookDto.getTitle();
         jdbcTemplate.update(
                "UPDATE author title publication_year SET author = ? publication_year = ? FROM _book WHERE title = ?",
                bookDto.getAuthor(),bookDto.getPublicationYear(), title);

    }

    public void deleteBookByTitle(String title){
        jdbcTemplate.update("DELETE FROM _book WHERE title = ?",
                title
        );
    }






}
