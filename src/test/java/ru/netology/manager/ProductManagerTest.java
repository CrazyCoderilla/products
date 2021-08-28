package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductManagerTest {
    private ProductManager pm;
    private final static String text = "123";

    @BeforeEach
    public void setUp() {
        pm = new ProductManager(new ProductRepository());
        pm.add(new Book(1, text, 1, text, 1, 1));
        pm.add(new Book(2, text, 1, text, 1, 1));
    }

    @Test
    public void searchByTest() {
        assertEquals(2, pm.searchBy(text).length);
        assertEquals(text, ((Book) pm.searchBy(text)[1]).getAuthor());

        assertEquals(0, pm.searchBy("11").length);
    }

}
