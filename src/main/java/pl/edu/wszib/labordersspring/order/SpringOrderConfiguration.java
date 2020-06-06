package pl.edu.wszib.labordersspring.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.wszib.labordersspring.order.jpa.SpringDataJpaOrderRepository;

@Configuration
public class SpringOrderConfiguration {
    @Bean
    public OrderService orderService() {
        return new OrderService(orderRepository());
    }

    @Bean
    public OrderRepository orderRepository() {
        return new SpringDataJpaOrderRepository();
    }
}
