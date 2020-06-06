package pl.edu.wszib.labordersspring.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.wszib.labordersspring.order.jpa.SpringDataJpaOrderDao;
import pl.edu.wszib.labordersspring.order.jpa.SpringDataJpaOrderRepository;

@Configuration
public class SpringOrderConfiguration {
    @Bean
    public OrderService orderService(SpringDataJpaOrderDao springDataJpaOrderDao) {
        return new OrderService(orderRepository(springDataJpaOrderDao));
    }

    @Bean
    public OrderRepository orderRepository(SpringDataJpaOrderDao springDataJpaOrderDao) {
        return new SpringDataJpaOrderRepository(springDataJpaOrderDao);
    }
}
