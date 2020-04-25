package pl.edu.wszib.labordersspring.ui;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pl.edu.wszib.labordersspring.order.OrderService;

@Configuration
public class UISpringRunner implements CommandLineRunner {
    private final OrderService orderService;

    public UISpringRunner(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) throws Exception {
        ConsoleUI consoleUI = new ConsoleUI(orderService);
        consoleUI.start();
    }
}
