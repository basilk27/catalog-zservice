package com.mbsystems.catalogservice.service;

import com.mbsystems.catalogservice.domain.Book;
import com.mbsystems.catalogservice.exception.BookAlreadyExistsException;
import com.mbsystems.catalogservice.exception.BookNotFoundException;
import com.mbsystems.catalogservice.repository.InMemoryBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final InMemoryBookRepository inMemoryBookRepository;

    public Iterable<Book> viewBookList() {
        return this.inMemoryBookRepository.findAll();
    }

    public Book viewBookDetails( String isbn ) {
        return this.inMemoryBookRepository
                .findByIsbn( isbn )
                .orElseThrow( () -> new BookNotFoundException( isbn ) );
    }

    public Book addBookToCatalog( Book book ) {
        if ( this.inMemoryBookRepository.existsByIsbn(book.isbn()) ) {
            throw new BookAlreadyExistsException( book.isbn() );
        }

        return this.inMemoryBookRepository.save( book );
    }

    public void removeBookFromCatalog( String isbn ) {
        this.inMemoryBookRepository.deleteByIsbn( isbn );
    }

    public Book editBookDetails( String isbn, Book book ) {
        return this.inMemoryBookRepository
                .findByIsbn( isbn )
                .map( existingBook -> {
                    var bookUpdate = new Book(
                            existingBook.isbn(),
                            book.title(),
                            book.author(),
                            book.price()
                    );
                    return this.inMemoryBookRepository.save( bookUpdate );
                })
                .orElseGet( () -> addBookToCatalog( book ) );
    }
}
