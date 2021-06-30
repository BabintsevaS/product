package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    public void shouldSearchByBook() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book first = new Book(1, "book1", 300, "Pushkin");
        Book second = new Book(2, "book2", 500, "Tolstoy");
        Book third = new Book(3, "book3", 700, "Lermontov");

        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product[] expected = {second};
        Product[] actual = manager.searchBy("Tolstoy");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByBookWithName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book first = new Book(1, "book1", 300, "Pushkin");
        Book second = new Book(2, "book2", 500, "Tolstoy");
        Book third = new Book(3, "book3", 700, "Lermontov");

        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product[] expected = {third};
        Product[] actual = manager.searchBy("book3");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByBookNotMatchesItem() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book first = new Book(1, "book1", 300, "Pushkin");
        Book second = new Book(2, "book2", 500, "Tolstoy");
        Book third = new Book(3, "book3", 700, "Lermontov");

        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Nekrasov");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchBySmartphone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Smartphone first = new Smartphone(1, "phone", 2000, "USA");
        Smartphone second = new Smartphone(2, "phone", 1500, "China");
        Smartphone third = new Smartphone(3, "phone", 1700, "Japan");

        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product[] expected = {third};
        Product[] actual = manager.searchBy("Japan");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchBySmartphoneWithName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Smartphone first = new Smartphone(1, "phone1", 2000, "USA");
        Smartphone second = new Smartphone(2, "phone2", 1500, "China");
        Smartphone third = new Smartphone(3, "phone3", 1700, "Japan");

        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product[] expected = {first};
        Product[] actual = manager.searchBy("phone1");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchBySmartphoneNotMatchesItem() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Smartphone first = new Smartphone(1, "phone1", 2000, "USA");
        Smartphone second = new Smartphone(2, "phone2", 1500, "China");
        Smartphone third = new Smartphone(3, "phone3", 1700, "Japan");

        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Russia");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByProductNotMatchesItem() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Product first = new Product(1, "t-shirt1", 200);
        Product second = new Product(2, "t-shirt2", 100);
        Product third = new Product(3, "t-shirt3", 150);

        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product[] expected = {};
        Product[] actual = manager.searchBy("t-shirt3");

        Assertions.assertArrayEquals(expected, actual);

    }
}