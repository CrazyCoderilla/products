package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductManagerTest {
    ProductManager pm = new ProductManager(new ProductRepository());
    String text = "123";
    String megatext = "456";
    Book book = new Book(1, text, 1, text, 1, 1);
    Book megabook = new Book(1, megatext, 1, megatext, 1, 1);

    @BeforeEach
    public void setUp() {
        pm.add(book);
        pm.add(megabook);
    }

    @Test
    public void searchByTest() {
        assertEquals(1, pm.searchBy(text).length);
        assertEquals(1, pm.searchBy(megatext).length);
        assertEquals(text, ((Book) pm.searchBy(text)[0]).getAuthor());

        assertEquals(0, pm.searchBy("11").length);

    }

}
