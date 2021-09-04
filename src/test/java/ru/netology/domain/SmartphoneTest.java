package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmartphoneTest {

    @Test
    public void trueMatchesTest() {
        String manu = "123";
        Smartphone smartphone = new Smartphone(1, "smartphone_model", manu, 10);
        assertTrue(smartphone.matches(manu));
    }

    @Test
    public void falseMatchesTest() {
        String manu = "123";
        Smartphone smartphone = new Smartphone(1, "smartphone_model", manu, 10);
        assertFalse(smartphone.matches("5"));
    }
}
