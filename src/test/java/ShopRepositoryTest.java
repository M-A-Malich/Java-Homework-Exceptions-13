import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void testRemovedProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(2, "Книга", 500 );
        Product product2 = new Product(5, "Телефон", 50_000 );
        Product product3 = new Product(4, "Самокат", 20_000 );

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(5);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemovedProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(2, "Книга", 500 );
        Product product2 = new Product(5, "Телефон", 50_000 );
        Product product3 = new Product(4, "Самокат", 20_000 );

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(1)
                );

    }

}
