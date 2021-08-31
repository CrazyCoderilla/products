package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import java.util.Arrays;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                Arrays.stream(result).forEach(value -> tmp[0] = value);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

}
