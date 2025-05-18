package com.heodae.exchangebooks.dto.book;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookRequestDto {
    private String title;
    private String author;
    private String publisher;
    private String isbn;
}
