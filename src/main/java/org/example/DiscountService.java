package org.example;

public class DiscountService {
    public double calculateDiscount(int itemCount) {
        if (itemCount > 10) {
            return 0.10;
        }
        return 0.0;
    }
}
