package pl.edu.wszib.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderServiceTest {

    private OrderService orderService;

    @BeforeEach
    public void setup() {
        OrderRepository orderRepository = new InMemoryOrderRepository();
        orderService = new OrderService(orderRepository);
    }

    @Test
    public void shouldBeAbleToCreateOrder() {
        // given:
        Order order = OrderSample.sample();

        // when:
        String orderId = orderService.create(order);

        // then:
        assertNotNull(orderId);
        boolean exists = orderService.exists(orderId);
        assertTrue(exists);
    }

    @Test
    public void shouldBeAbleToAddPositionToOrder() {
        // given:
        Position position = PositionSamples.sample();
        Order order = OrderSample.sample();
        String orderId = orderService.create(order);

        // when:
        orderService.addPosition(orderId, position);
        orderService.addPosition(orderId, position);
        orderService.addPosition(orderId, position);
        orderService.addPosition(orderId, position);
        orderService.addPosition(orderId, position);

        // then:
        Order newOrder = orderService.find(orderId);
        boolean hasPosition = newOrder.hasPosition(position);
        assertTrue(hasPosition);
    }

}