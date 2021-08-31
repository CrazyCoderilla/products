package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductManagerTest {
    private ProductManager pm;
    private final static String book_name = "123";
    private final static String book_author = "book";
    private final static String smartphone_model = "aa";
    private final static String smartphone_manu = "sam";
    private Book b1;
    private Book b2;
    private Smartphone sm = new Smartphone();


    @BeforeEach
    public void setUp() {
        pm = new ProductManager(new ProductRepository());
        b1 = new Book(1, book_name, 1, book_author, 1, 1);
        b2 = new Book(1, book_name, 1, book_author, 1, 1);
        sm = new Smartphone();
        pm.add(b1);
        pm.add(b2);
        sm.setManufacturer(smartphone_manu);
        sm.setName(smartphone_model);
        pm.add(sm);
    }

    @Test
    public void searchBookTest() {
        assertEquals(2, pm.searchBy(book_name).length);
        assertEquals(book_author, ((Book) pm.searchBy(book_author)[1]).getAuthor());
        assertEquals(0, pm.searchBy("11").length);
    }

    @Test
    public void searchSmartTest() {
        assertEquals(smartphone_model, pm.searchBy(smartphone_model)[0].getName());
        assertEquals(smartphone_manu, ((Smartphone) pm.searchBy(smartphone_manu)[0]).getManufacturer());

        Product[] expected = {sm};
//        assertEquals(expected, pm.searchBy(smartphone_manu));
        assertEquals(expected[0].getName(), pm.searchBy(smartphone_manu)[0].getName());

    }

}
