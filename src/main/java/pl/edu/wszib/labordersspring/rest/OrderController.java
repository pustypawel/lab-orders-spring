package pl.edu.wszib.labordersspring.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.labordersspring.order.Order;
import pl.edu.wszib.labordersspring.order.OrderService;
import pl.edu.wszib.labordersspring.order.exception.OrderNotFoundException;
import pl.edu.wszib.labordersspring.rest.api.OrderCreateDto;
import pl.edu.wszib.labordersspring.rest.api.OrderDto;

import javax.validation.Valid;
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
    public String create(@RequestBody @Valid OrderCreateDto orderCreateDto) {   // może być również @Validated
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

    @GetMapping(path = "/{orderId}")
    public OrderDto getOne(@PathVariable("orderId") String orderId) {
        return orderService.getOne(orderId);
    }
}
