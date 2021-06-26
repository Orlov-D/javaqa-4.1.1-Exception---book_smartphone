package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.discovery.SelectorResolver;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    Book book1 = new Book(0, "Редиска", 132, "Соня Уайт");

    @Test
    public void shouldMatch (){
        assertEquals(true, book1.matches("Со"));
    }

    @Test
    public void shouldNotMatch (){
        assertEquals(false, book1.matches("ри"));
    }

    @Test

    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Book book = new Book();
    }

    @Test
    public void shouldCastFromBaseClass() {
        Product product = new Book();
        if (product instanceof Book) {
            Book book = (Book) product;
        }
    }

//    @Test
//    public void shouldNotCastToDifferentClass() {
//        Product product = new Book();
//        TShirt shirt = (TShirt) product;
//    }

    @Test
    public void shouldUseOverridedMethod() {
        Product product = new Book();
        product.toString();
    }
}