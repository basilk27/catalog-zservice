//package com.mbsystems.catalogservice.repository;
//
//import com.mbsystems.catalogservice.config.JdbcDataConfig;
//import com.mbsystems.catalogservice.domain.Book;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.context.annotation.Import;
//import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJdbcTest
//@Import(JdbcDataConfig.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ActiveProfiles("intergration")
//class BookRepositoryTest {
//
//    @Autowired
//    private BookRepository bookRepository;
//
//    @Autowired
//    private JdbcAggregateTemplate jdbcAggregateTemplate;
//
//    @BeforeEach
//    void setUp() {
//    }
//
//    @Test
//    void findBookByIsbnWhenExisting() {
//        var bookIsbn = "1234561237";
//
//        var book = Book.of(bookIsbn, "Title", "Author", 12.90);
//
//        jdbcAggregateTemplate.insert( book );
//
//        Optional<Book> optionalBook = bookRepository.findByIsbn( bookIsbn );
//
//        assertThat( optionalBook ).isPresent();
//        assertThat( optionalBook.get().isbn() ).isEqualTo( book.isbn() );
//    }
//}