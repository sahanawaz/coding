package Ecommerce;

import java.time.LocalDateTime;
import java.util.List;

public record Order(
        Long id, Long customerId, LocalDateTime ts, List<OrderItem> items, String status
) {
}
