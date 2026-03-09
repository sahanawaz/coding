package Ecommerce;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EcommerceService {

    public void processOrder() {
        // Build O(1) lookup for product by id
        Map<Long, Product> productLookUp = Data.products.stream()
                .collect(Collectors.toMap(Product::id, Function.identity()));
        Map<String, List<Product>> categoryLookUp = Data.products.stream()
                .collect(Collectors.groupingBy(Product::category));


        Map<Long, Double> prodRev = computeRevenueByProduct(productLookUp);

        // ==== Pretty print outputs ====
        System.out.println("=== Revenue by Product (Totals) ===");
        prodRev.forEach((k,v) ->  System.out.printf("%-18s : %.2f%n",
                productLookUp.get(k).name(), v));

        System.out.println("=== Revenue by Category (Totals) ===");
        categoryLookUp.entrySet().stream()
                .peek(entry -> System.out.println("Category: " + entry.getKey()))
                .forEach(entry -> {
                    entry.getValue().forEach(p -> System.out.printf("   %-18s : %.2f%n",
                            p.name(), prodRev.get(p.id())));
                });


    }

    /**
     * This method will perform the following task
     * - Filter out the delivered orders from order list
     * - Flatten the order items
     * - Group the items by product id and sum their quantities
     * - Finally, group the result by product id and using look up find the revenue
     * @param productLookUp - Look up table for finding product on ID
     * @return A Map of data representing the revenue by product
     */
    public Map<Long, Double> computeRevenueByProduct(Map<Long, Product> productLookUp) {
        return Data.orders.stream()
                .filter(o -> o.status().equals("DELIVERED"))
                .flatMap(o -> o.items().stream())
                .collect(Collectors.groupingBy(OrderItem::productId, Collectors.summingLong(OrderItem::qty)))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            double price = productLookUp.get(entry.getKey()).price();
                            long qty = entry.getValue();
                            return price * qty;
                        }
                ));
    }
}
