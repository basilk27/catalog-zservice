//package com.mbsystems.catalogservice.domain;
//
//
//import jakarta.validation.ConstraintViolation;
//import jakarta.validation.Validation;
//import jakarta.validation.Validator;
//import jakarta.validation.ValidatorFactory;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import java.util.Set;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class BookValidationTests {
//
//    private static Validator validator;
//
//    @BeforeAll
//    static void setUp() {
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//
//        validator = factory.getValidator();
//    }
//
//    @Test
//    void whenAllFieldsCorrectThenValidationSucceeds() {
//        var aBook = Book.of("1234567890", "Title", "Author", 9.90);
//
//        Set<ConstraintViolation<Book>> violations = validator.validate( aBook );
//
//        assertThat(violations).isEmpty();
//    }
//
//    @Test
//    void whenIsbnDefinedButInCorrectThenValidationFails() {
//        var aBook = Book.of("a234567890", "Title", "Author", 9.90);
//
//        Set<ConstraintViolation<Book>> violations = validator.validate( aBook );
//
//        assertThat(violations).hasSize(1);
//        assertThat(violations.iterator().next().getMessage()).isEqualTo("The ISBN Format must be valid.");
//    }
//}
