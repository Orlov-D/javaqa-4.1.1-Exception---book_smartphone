package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    Smartphone smartphone1 = new Smartphone(2, "Кнопочный", 31500, "Сони");

    @Test
    public void shouldMatch (){
        assertEquals(true, smartphone1.matches("Со"));
    }

    @Test
    public void shouldNotMatch (){
        assertEquals(false, smartphone1.matches("ри"));
    }

}