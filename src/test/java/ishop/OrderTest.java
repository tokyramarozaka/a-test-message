package ishop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    private Product supra;
    private Product skyline;
    private Order order;
    private Customer customer;

    @BeforeEach
    void setUp() {
        supra = new Product(1, "Toyota Supra Rz", "A magnificant tuner car", VEHICLE, new ArrayList<PriceHistory>(
            new PriceHistory(1,BigDecimal.valueOf(58_000), Instant.parse("2025-01-01T00:00:00Z")),
            new PriceHistory(2, BigDecimal.valueOf(69_000), Instant.parse("2026-01-01T00:00:00Z"))
        );
        skyline = new Product(2, "Nissan Skyline GT-R 34", "The legendary vehicle from Fast and furious", VEHICLE, new ArrayList<PriceHistory>(
            new PriceHistory(1, BigDecimal.valueOf(15_000), Instant.parse("2025-01-01T00:00:00Z")),
            new PriceHistory(2, BigDecimal.valueOf(30_000), Instant.parse("2025-06-01T00:00:00Z"))
        );
        customer = new Customer(1, "CL001","Dominique", "Torreto","torreto@mail.com","azerty", "+123 456 789");
    }
    @Test
    void getTotalCost_withOrderForToday_shouldUseTodaysPrices() {
        order = new Order(1, Instant.now(), Instant.now(), customer, new ArrayList<>(
            new OrderItem(1, 2, supra),
            new OrderItem(2, 1, skyline)
        ));
        assertEquals(BigDecimal.valueOf(168_000),order.getTotalCost());
    }

    @Test
    void getTotalCost_withPastOrder_shouldUsePastPrices() {
        order = new Order(1, Instant.parse("2025-08-01T00:00:00Z"), Instant.parse("2025-08-01T00:00:00Z"), customer, new ArrayList<>(
            new OrderItem(1, 3, supra),
            new OrderItem(2, 10, skyline)
        ));
        assertEquals(BigDecimal.valueOf(474_000), order.getTotalCost());
    }
}
