package pl.edu.wszib.labordersspring.rest;

import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.labordersspring.order.Order;
import pl.edu.wszib.labordersspring.order.OrderService;
import pl.edu.wszib.labordersspring.rest.api.OrderCreateDto;
import pl.edu.wszib.labordersspring.rest.api.OrderDto;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public List<OrderDto> getAll() {
        return orderService.getAll().stream()
                .map(Order::toDto)
                .collect(Collectors.toList());
    }
}
