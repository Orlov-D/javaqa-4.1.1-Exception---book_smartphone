package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product1 = new Product(0, "Редиска", 132);

    @Test
    public void shouldMatch (){
        assertEquals(true, product1.matches("ди"));
    }

    @Test
    public void shouldNotMatch (){
        assertEquals(false, product1.matches("ри"));
    }

    @Test
    public void shouldUseEquals() {
        Product first = new Product(1, "Java I", 1000);
        Product second = new Product(1, "Java I", 1000);
        assertEquals(first, second);
    }
}