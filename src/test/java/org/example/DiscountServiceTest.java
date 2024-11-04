package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DiscountServiceTest {

    private final DiscountService discountService = new DiscountService();

    @ParameterizedTest
    @CsvSource({
            "5, 0.0",
            "10, 0.0",
            "11, 0.10",
            "20, 0.10"
    })
    void testCalculateDiscount(int itemCount, double expectedDiscount) {
        double discount = discountService.calculateDiscount(itemCount);
        assertEquals(expectedDiscount, discount, 0.01);
    }
}
