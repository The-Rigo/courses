package com.diplomado.courses.service.implement;

import com.diplomado.courses.domain.entities.Book;
import com.diplomado.courses.repositories.BookRepository;
import com.diplomado.courses.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBookByStudent(Integer studentId) {
        return  bookRepository.findAll().stream()
                .filter(book -> Objects.equals(book.getStudent().getId(), studentId)).collect(Collectors.toList());
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
}
