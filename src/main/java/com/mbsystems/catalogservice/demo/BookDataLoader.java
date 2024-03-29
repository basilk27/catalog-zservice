package com.mbsystems.catalogservice.demo;

import com.mbsystems.catalogservice.domain.Book;
import com.mbsystems.catalogservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Profile("testdata")
public class BookDataLoader {

    private final BookRepository bookRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        this.bookRepository.deleteAll();

        var book1 = Book.of("1234567891", "Northern Lights", "Lyra Silverstar", 9.90);
        var book2 = Book.of("1234567892", "Polar Journey", "Iorek Polarson", 12.90);

        this.bookRepository.saveAll(List.of(book1, book2 ));
    }
}
