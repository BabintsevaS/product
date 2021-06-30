package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    // добавьте необходимые поля, конструкторы и методы
    private ProductRepository repository;

    public ProductManager(ProductRepository repo) {
        repository = repo;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (((Book) product).getAuthor().contains(search)) {
                return true;
            }
            if (product.getName().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (((Smartphone) product).getProducer().contains(search)) {
                return true;
            }
            if (product.getName().contains(search)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
