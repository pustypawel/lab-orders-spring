package pl.edu.wszib.labordersspring.order;

import pl.edu.wszib.labordersspring.order.exception.OrderNotFoundException;
import pl.edu.wszib.labordersspring.rest.api.OrderDto;

import java.util.Collection;

public interface OrderRepository {
    String save(Order order);
    boolean exists(String orderId);
    Order load(String orderId);
    Collection<Order> getAll();
    Order getOne(String orderId) throws OrderNotFoundException;
}
