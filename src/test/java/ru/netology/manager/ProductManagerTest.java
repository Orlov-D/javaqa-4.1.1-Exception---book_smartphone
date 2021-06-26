package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.TShirt;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository productRepository = new ProductRepository();
    ProductManager productManager = new ProductManager(productRepository);

    Book book1 = new Book(0, "Редиска", 132, "Соня Уайт");
    Book book2 = new Book(1, "Барбоскины", 99, "Ингрет ВИнегрет");
    Smartphone smartphone1 = new Smartphone(2, "Кнопочный", 31500, "Сони");
    Smartphone smartphone2 = new Smartphone(3, "Несколько", 7200, "Яблок");
    TShirt tShirt = new TShirt(5, "Бодик", 1500, "Зеленая","25");

    @Test
    void searchByMany() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(tShirt);

        assertArrayEquals(new Product[]{book1,smartphone1},productManager.searchBy("Со"));
    }

    @Test
    void searchByOneTrue() {
        productManager.add(book1);

        assertArrayEquals(new Product[]{book1},productManager.searchBy("Со"));
    }

    @Test
    void searchByOneFalse() {
        productManager.add(book2);

        assertArrayEquals(new Product[]{},productManager.searchBy("Со"));
    }

    @Test
    void searchByZero() {
        assertArrayEquals(new Product[]{},productManager.searchBy("В"));
    }
}