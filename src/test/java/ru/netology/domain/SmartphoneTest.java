package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmartphoneTest {

    @Test
    public void matchesTest() {
        Smartphone smartphone = new Smartphone();
        String manu = "123";
        smartphone.setManufacturer(manu);
        assertTrue(smartphone.matches(manu));
        assertFalse(smartphone.matches("5"));
    }
}
