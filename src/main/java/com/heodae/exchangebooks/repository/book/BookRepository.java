package com.heodae.exchangebooks.repository.book;

import com.heodae.exchangebooks.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByIsbnAndTitle(String isbn, String title);
}
