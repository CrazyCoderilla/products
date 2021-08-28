package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void trueMatchesTest() {
        Book book = new Book();
        String author = "123";
        book.setAuthor(author);
        assertTrue(book.matches(author));
    }

    @Test
    public void falseMatchesTest() {
        Book book = new Book();
        String author = "123";
        book.setAuthor(author);
        assertFalse(book.matches("5"));
    }

}
