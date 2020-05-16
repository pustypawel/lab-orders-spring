package pl.edu.wszib.labordersspring.order;

import java.util.Collection;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String create(Order order) {
        return orderRepository.save(order);
    }

    public boolean exists(String orderId) {
        return orderRepository.exists(orderId);
    }

    public void addPosition(String orderId, Position position) {
        Order order = orderRepository.load(orderId);
        order.addPosition(position);
        orderRepository.save(order);
    }

    public Order find(String orderId) {
        return orderRepository.load(orderId);
    }

    public Collection<Order> getAll() {
        return orderRepository.getAll();
    }
}
