package com.heodae.exchangebooks.dto.book;

import com.heodae.exchangebooks.domain.book.Book;
import lombok.Getter;

@Getter
public class BookResponseDto {
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String isbn;

    public BookResponseDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.publisher = book.getPublisher();
        this.isbn = book.getIsbn();
    }
}
