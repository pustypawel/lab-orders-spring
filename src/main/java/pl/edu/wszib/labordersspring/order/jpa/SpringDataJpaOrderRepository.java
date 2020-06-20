package pl.edu.wszib.labordersspring.order.jpa;

import pl.edu.wszib.labordersspring.order.Order;
import pl.edu.wszib.labordersspring.order.OrderRepository;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

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
        return springDataJpaOrderDao.existsById(orderId);
    }

    @Override
    public Order load(String orderId) {
        return springDataJpaOrderDao.findById(orderId)
                .map(Order::fromEntity)
                .orElse(null);  // TODO propagate optional
    }

    @Override
    public Collection<Order> getAll() {
        return springDataJpaOrderDao.findAll().stream()
                .map(Order::fromEntity)
                .collect(Collectors.toList());
    }

}
