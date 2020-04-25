package pl.edu.wszib.labordersspring.ui;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pl.edu.wszib.labordersspring.order.InMemoryOrderRepository;
import pl.edu.wszib.labordersspring.order.OrderService;

@Configuration
public class UISpringRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        InMemoryOrderRepository inMemoryOrderRepository = new InMemoryOrderRepository();
        OrderService orderService = new OrderService(inMemoryOrderRepository);
        ConsoleUI consoleUI = new ConsoleUI(orderService);
        consoleUI.start();
    }
}
