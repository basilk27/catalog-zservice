package com.mbsystems.catalogservice.demo;

import com.mbsystems.catalogservice.domain.Book;
import com.mbsystems.catalogservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("testdata")
public class BookDataLoader {

    private final BookRepository bookRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        var book1 = new Book("1234567891", "Northern Lights", "Lyra Silverstar", 9.90);
        var book2 = new Book("1234567892", "Polar Journey", "Iorek Polarson", 12.90);

        this.bookRepository.save( book1 );
        this.bookRepository.save( book2 );
    }
}