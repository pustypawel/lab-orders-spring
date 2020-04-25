package pl.edu.wszib.labordersspring.order;

public interface OrderRepository {
    String save(Order order);
    boolean exists(String orderId);
    Order load(String orderId);
}
