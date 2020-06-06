package pl.edu.wszib.labordersspring.order.jpa;

import pl.edu.wszib.labordersspring.order.Order;
import pl.edu.wszib.labordersspring.order.OrderRepository;
import pl.edu.wszib.labordersspring.order.exception.OrderNotFoundException;

import java.util.Collection;

public class SpringDataJpaOrderRepository implements OrderRepository {
    @Override
    public String save(Order order) {
        return null;
    }

    @Override
    public boolean exists(String orderId) {
        return false;
    }

    @Override
    public Order load(String orderId) {
        return null;
    }

    @Override
    public Collection<Order> getAll() {
        return null;
    }

    @Override
    public Order getOne(String orderId) throws OrderNotFoundException {
        return null;
    }
}
