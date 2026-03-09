package Ecommerce;

import java.time.LocalDateTime;
import java.util.List;

public class Data {
    public static List<Product> products = List.of(
            new Product(101L, "iPhone 15", "Electronics", 799.0),
            new Product(102L, "Samsung Galaxy S24", "Electronics", 699.0),
            new Product(103L, "Sony WH-1000XM5", "Electronics", 349.0),
            new Product(201L, "Nike Air Max", "Fashion", 129.0),
            new Product(202L, "Levi's Jeans", "Fashion", 89.0),
            new Product(301L, "Instant Pot Duo", "Home Appliances", 119.0),
            new Product(302L, "Dyson Vacuum V12", "Home Appliances", 599.0),
            new Product(203L, "T-Shirt Basic", "Fashion", 19.0),
            new Product(104L, "Asus ROG Laptop", "Electronics", 1499.0),
            new Product(303L, "Mixer Grinder", "Home Appliances", 79.0)
    );

    List<Order> orders = List.of(
            new Order(
                    1001L, 501L,
                    LocalDateTime.of(2024, 1, 10, 14, 30),
                    List.of(
                            new OrderItem(101L, 1),
                            new OrderItem(103L, 2)
                    ),
                    "DELIVERED"
            ),
            new Order(
                    1002L, 502L,
                    LocalDateTime.of(2024, 1, 12, 9, 10),
                    List.of(
                            new OrderItem(201L, 3),
                            new OrderItem(203L, 5)
                    ),
                    "DELIVERED"
            ),
            new Order(
                    1003L, 503L,
                    LocalDateTime.of(2024, 1, 13, 18, 22),
                    List.of(
                            new OrderItem(301L, 1),
                            new OrderItem(302L, 1)
                    ),
                    "CANCELLED"
            ),
            new Order(
                    1004L, 504L,
                    LocalDateTime.of(2024, 1, 15, 11, 5),
                    List.of(
                            new OrderItem(102L, 2),
                            new OrderItem(202L, 1)
                    ),
                    "DELIVERED"
            ),
            new Order(
                    1005L, 505L,
                    LocalDateTime.of(2024, 1, 17, 16, 49),
                    List.of(
                            new OrderItem(104L, 1)
                    ),
                    "DELIVERED"
            ),
            new Order(
                    1006L, 501L,
                    LocalDateTime.of(2024, 1, 20, 20, 15),
                    List.of(
                            new OrderItem(302L, 1),
                            new OrderItem(303L, 2)
                    ),
                    "DELIVERED"
            )
    );
}
