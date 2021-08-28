package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Book book = new Book();
//    book.
    }

    @Test
    public void shouldCastFromBaseClass() {
    }

    @Test
    public void shouldNotCastToDifferentClass() {

    }

    @Test
    public void shouldUseOverridedMethod() {

    }

    @Test
    public void matchesTest() {
        Book book = new Book();
        String author = "123";
        book.setAuthor(author);
        assertTrue(book.matches(author));
        assertFalse(book.matches("5"));
    }
}
