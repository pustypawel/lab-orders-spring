package pl.edu.wszib.labordersspring.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wszib.labordersspring.order.Order;
import pl.edu.wszib.labordersspring.order.OrderService;
import pl.edu.wszib.labordersspring.rest.api.OrderCreateDto;

import java.util.List;

@RequestMapping("/api/orders")
@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public String create(@RequestBody OrderCreateDto orderCreateDto) {
        List<OrderCreateDto.Position> positions = orderCreateDto.getPositions();
        Order order = new Order(positions);
        return orderService.create(order);
    }
}
