package pl.edu.wszib.labordersspring.order;

import java.util.*;

public class InMemoryOrderRepository implements OrderRepository {

    private final Map<String, Order> ordersMap = new HashMap<>();

    @Override
    public String save(Order order) {
        String id = order.getId();
        if (id == null) {
            id = UUID.randomUUID().toString();
            order.setId(id);
        }
        ordersMap.put(id, order);
        return id;
    }

    @Override
    public boolean exists(String orderId) {
        return ordersMap.containsKey(orderId);
    }

    @Override
    public Order load(String orderId) {
        return ordersMap.get(orderId);
    }

    @Override
    public Collection<Order> getAll() {
        return ordersMap.values();
    }

}
