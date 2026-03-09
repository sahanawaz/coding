package Ecommerce;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EcommerceService {

    public void processOrder() {
        // Build O(1) lookup for product by id
        Map<Long, Product> productById = Data.products.stream()
                .collect(Collectors.toMap(Product::id, Function.identity()));


    }
}
