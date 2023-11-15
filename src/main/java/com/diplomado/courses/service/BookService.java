package com.diplomado.courses.service;

import com.diplomado.courses.domain.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> getBookByStudent(Integer studentId);
    Book save(Book book);
}
