package com.heodae.exchangebooks.service.book;

import com.heodae.exchangebooks.domain.book.Book;
import com.heodae.exchangebooks.dto.book.BookRequestDto;
import com.heodae.exchangebooks.dto.book.BookResponseDto;
import com.heodae.exchangebooks.repository.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Long register(BookRequestDto dto) {
        Book book = Book.builder()
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .publisher(dto.getPublisher())
                .isbn(dto.getIsbn())
                .build();
        return bookRepository.save(book).getId();
    }

    public List<BookResponseDto> findAll() {
        return bookRepository.findAll().stream()
                .map(BookResponseDto::new)
                .collect(Collectors.toList());
    }
}
