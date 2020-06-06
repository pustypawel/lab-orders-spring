package pl.edu.wszib.labordersspring.order.jpa;

import pl.edu.wszib.labordersspring.order.Order;
import pl.edu.wszib.labordersspring.order.OrderRepository;
import pl.edu.wszib.labordersspring.order.exception.OrderNotFoundException;

import java.util.Collection;
import java.util.UUID;

public class SpringDataJpaOrderRepository implements OrderRepository {
    private final SpringDataJpaOrderDao springDataJpaOrderDao;

    public SpringDataJpaOrderRepository(SpringDataJpaOrderDao springDataJpaOrderDao) {
        this.springDataJpaOrderDao = springDataJpaOrderDao;
    }

    @Override
    public String save(Order order) {
        String id = order.getId();
        if (id == null) {
            id = UUID.randomUUID().toString();
            order.setId(id);
        }
        OrderEntity orderEntity = order.toEntity();
        springDataJpaOrderDao.saveAndFlush(orderEntity);
        return id;
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
