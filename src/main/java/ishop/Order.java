package ishop;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public record Order(int id, Instant createdAt, Instant updatedAt, Customer customer, List<OrderItem> orderItems) {
    public BigDecimal getTotalCost() {
        throw new RuntimeException("Not implemented");
    }
}
