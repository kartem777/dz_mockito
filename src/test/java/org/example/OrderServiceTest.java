package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @Mock
    private DiscountService discountService;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPlaceOrderWithDiscount() {
        Order order = new Order(Arrays.asList("item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8", "item9", "item10", "item11"), 200.0);

        when(discountService.calculateDiscount(order.getItemCount())).thenReturn(0.1);

        double finalPrice = orderService.placeOrder(order);

        assertEquals(180.0, finalPrice, 0.001);
        verify(discountService, times(1)).calculateDiscount(order.getItemCount());
    }

    @Test
    public void testPlaceOrderWithoutDiscount() {
        Order order = new Order(Arrays.asList("item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8", "item9", "item10"), 100.0);

        when(discountService.calculateDiscount(order.getItemCount())).thenReturn(0.0);

        double finalPrice = orderService.placeOrder(order);

        assertEquals(100.0, finalPrice, 0.001);
        verify(discountService, times(1)).calculateDiscount(order.getItemCount());
    }
}
