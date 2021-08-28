package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductManagerTest {

    @Test
    public void searchByTest() {
        String text = "123";
        Book book = new Book(1, text, 1, text, 1, 1);

        ProductManager pm = new ProductManager(new ProductRepository());
        pm.add(book);

        assertEquals(1, pm.searchBy(text).length);
        assertEquals(text, ((Book) pm.searchBy(text)[0]).getAuthor());

        assertEquals(0, pm.searchBy("11").length);

    }

}
