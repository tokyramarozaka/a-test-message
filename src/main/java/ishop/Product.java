package ishop;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public record Product(int id, String name, String description, ProductCategory productCategory,
                      List<PriceHistory> priceHistories) {
    public BigDecimal getCurrentPrice() {
        throw new RuntimeException("Not implemented");
    }

    public BigDecimal getPriceAt(Instant t) {
        throw new RuntimeException("Not implemented");
    }
}

