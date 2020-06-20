package pl.edu.wszib.labordersspring.order;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.labordersspring.rest.api.OrderDto;

import java.util.Collection;

@Transactional
public class OrderService {
    private final OrderRepository orderRepository;

    // manual transaction management
//    @Autowired
//    private PlatformTransactionManager transactionManager;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String create(Order order) {
        return orderRepository.save(order);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean exists(String orderId) {
        return orderRepository.exists(orderId);
    }

    public void addPosition(String orderId, Position position) {
        // manual transaction management
//        TransactionStatus transaction = transactionManager.getTransaction(new DefaultTransactionDefinition());
//        try {
//            transactionManager.commit(transaction);
//        } catch (Exception e) {
//            transactionManager.rollback(transaction);
//        }
        Order order = orderRepository.load(orderId);
        order.addPosition(position);
        orderRepository.save(order);
    }

    @Transactional(readOnly = true)
    public Order find(String orderId) {
        return orderRepository.load(orderId);
    }

    @Transactional(readOnly = true)
    public Collection<Order> getAll() {
        return orderRepository.getAll();
    }

    @Transactional(readOnly = true)
    public OrderDto getOne(String orderId) {
        // Przykład jak wywołać OrderErrorHandler.handleUnexpectedException
//        Order order = null;
//        return order.toDto();
        return orderRepository.getOne(orderId)
                .toDto();
    }
}
