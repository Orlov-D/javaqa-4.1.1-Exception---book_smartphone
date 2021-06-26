package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();
    Book book1 = new Book(0, "Редиска", 132, "Соня Уайт");
    Book book2 = new Book(1, "Барбоскины", 99, "Ингрет ВИнегрет");
    Smartphone smartphone1 = new Smartphone(2, "Кнопочный", 31500, "Сони");
    Smartphone smartphone2 = new Smartphone(3, "Несколько", 7200, "Яблок");


    @Test
    public void shouldDeleteItem() {
        repository.save(book1);
        repository.save(book2);
        repository.save(smartphone1);
        repository.save(smartphone2);

        repository.removeById(1);

        assertArrayEquals(new Product[] {book1,smartphone1,smartphone2}, repository.findAll());
    }

    @Test
    public void negativeId() {
        repository.save(coreJava);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(-3);
        });
    }

    @Test
    public void outOfLength() {
        repository.save(coreJava);
//Этот тест наверное лишний. Повторяет предыдущий.
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(10);
        });
    }

    @Test
    public void shouldSaveOneItem() {
        repository.save(coreJava);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}