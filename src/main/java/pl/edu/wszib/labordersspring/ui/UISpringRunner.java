package pl.edu.wszib.labordersspring.ui;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pl.edu.wszib.labordersspring.config.OrderConfig;
import pl.edu.wszib.labordersspring.order.OrderService;

@Configuration
public class UISpringRunner implements CommandLineRunner {
    private final OrderConfig orderConfig;
    private final OrderService orderService;

    public UISpringRunner(OrderConfig orderConfig,
                          OrderService orderService) {
        this.orderConfig = orderConfig;
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) throws Exception {
//        if (orderConfig.getUi().getEnabled()) {
//            ConsoleUI consoleUI = new ConsoleUI(orderService);
//            consoleUI.start();
//        }
    }
}
