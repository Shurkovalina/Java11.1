package manager;

import domain.Book;
import domain.Product;
import domain.TShirt;
import manager.ProductManager;
import org.junit.jupiter.api.Test;
import repository.NotFoundException;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    public void noNull() {
        ProductManager manager = new ProductManager(new ProductRepository());
        Product product1 = new Book(1, "book1", 10, "author1", 100, 1999);
        Product product2 = new Book(2, "book1", 10, "author1", 100, 1999);
        Product product3 = new Book(3, "book1", 10, "author1", 100, 1999);
        Product product4 = new TShirt(4, "TS", 170, "black", "42");

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);

        manager.removeById(2);

        assertThrows(NotFoundException.class, () -> manager.removeById(2)) ;
    }

    @Test
    public void thereIsNull() {
        ProductManager manager = new ProductManager(new ProductRepository());
        Product product1 = new Book(1, "book1", 10, "author1", 100, 1999);
        Product product2 = new TShirt(2, "TS", 170, "black", "42");

        manager.add(product1);
        manager.add(product2);

        manager.removeById(3);

        assertThrows(NotFoundException.class, () ->  manager.removeById(3));
    }
}