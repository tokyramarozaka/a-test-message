package ishop;

import java.math.BigDecimal;
import java.time.Instant;

public record PriceHistory(int id, BigDecimal price, Instant effectiveFrom) {
}
