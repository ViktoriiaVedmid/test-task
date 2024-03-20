package tasks;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskCategoryBooks {
    public class Product {
        private Long id;
        private String name;
        private String category;
        private Double price;
        private Set<Order> orders;

        public Product(long id, String name, String category, double price, Set orders) {
            this.id = id;
            this.name = name;
            this.category = category;
            this.price = price;
            this.orders = orders;
        }
    }

    public ArrayList<Product> createProductsList() {
        ArrayList<Product> productsList = new ArrayList<>();
        productsList.add(new Product(1, "SomeProduct1", "Books", 90, new HashSet()));
        productsList.add(new Product(2, "SomeProduct2", "Books", 130, new HashSet()));
        productsList.add(new Product(3, "SomeProduct3", "Pencil", 10, new HashSet()));
        productsList.add(new Product(4, "SomeProduct4", "Pen", 130, new HashSet()));
        productsList.add(new Product(5, "SomeProduct5", "Magazine", 130, new HashSet()));
        productsList.add(new Product(6, "SomeProduct6", "Magazine", 130, new HashSet()));
        productsList.add(new Product(6, "SomeProduct7", "Books", 1000, new HashSet()));
        return productsList;
    }

    public ArrayList<Product> filterProducts() {
        return (ArrayList<Product>) createProductsList()
                .stream()
                .filter(o -> o.category.equals("Books"))
                .filter(o -> o.price > 100)
                .collect(Collectors.toList());
    }

    @Test
    public void testSolution() {
        System.out.println("Products with category = 'Books' and price > 100:");
        filterProducts().stream().forEach(product -> System.out.println("id: " + product.id + "; name: " + product.name + "; category: " + product.category + "; price: " + product.price));
    }

    private class Order {
    }
}
