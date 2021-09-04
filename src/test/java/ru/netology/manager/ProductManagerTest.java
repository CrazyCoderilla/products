package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductManagerTest {
    private ProductManager pm;
    private final static String book_name = "123";
    private final static String book_author = "book";
    private final static String smartphone_model = "aa";
    private final static String smartphone_manu = "sam";
    private Book b1;
    private Book b2;
    private Smartphone sm;


    @BeforeEach
    public void setUp() {
        pm = new ProductManager(new ProductRepository());
        b1 = new Book(1, book_name, 1, book_author, 1, 1);
        b2 = new Book(2, book_name, 1, "author", 1, 1);
        sm = new Smartphone(1, smartphone_model, smartphone_manu,10);
        pm.add(b1);
        pm.add(b2);
        pm.add(sm);
    }

    @Test
    public void searchBookByNameTest() {
        Product[] expected = {b1, b2};
        Product[] actual = pm.searchBy(book_name);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBookByAuthorTest() {
        Product[] expected = {b1};
        Product[] actual = pm.searchBy(book_author);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBookTestEmptyResult() {
        Product[] expected = new Product[]{};
        Product[] actual = pm.searchBy("123123123");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSmartByManufacturerTest() {
        Product[] expected = {sm};
        Product[] actual = pm.searchBy(smartphone_manu);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSmartByModelTest() {
        Product[] expected = {sm};
        Product[] actual = pm.searchBy(smartphone_model);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSmartEmptyResultTest() {
        Product[] expected = new Product[]{};
        Product[] actual = pm.searchBy("80981283");
        assertArrayEquals(expected, actual);
    }

}
