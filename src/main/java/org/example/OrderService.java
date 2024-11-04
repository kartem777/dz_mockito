package org.example;

public class OrderService {
    private DiscountService discountService;

    public OrderService(DiscountService discountService) {
        this.discountService = discountService;
    }

    public double placeOrder(Order order) {
        int itemCount = order.getItemCount();
        double discount = discountService.calculateDiscount(itemCount);
        return order.getTotalPrice() * (1 - discount);
    }
}
