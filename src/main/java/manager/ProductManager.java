package manager;

import domain.Product;
import repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public Product[] items = new Product[0];

    public void add(Product item) {
        repository.save(item);
    }

    public void removeById(int id) {
        repository.removeById(id);
        System.out.println("manager done");
    }
}