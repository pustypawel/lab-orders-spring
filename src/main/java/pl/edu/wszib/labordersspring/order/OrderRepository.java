package pl.edu.wszib.labordersspring.order;

import java.util.Collection;

public interface OrderRepository {
    String save(Order order);
    boolean exists(String orderId);
    Order load(String orderId);
    Collection<Order> getAll();
}
