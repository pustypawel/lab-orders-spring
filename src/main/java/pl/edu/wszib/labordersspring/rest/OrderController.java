package pl.edu.wszib.labordersspring.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wszib.labordersspring.order.OrderService;
import pl.edu.wszib.labordersspring.rest.api.OrderCreateDto;

@RequestMapping("/api/orders")
@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public String create(@RequestBody OrderCreateDto orderCreateDto) {
        return orderService.create(null);   // TODO przemapować obiekt
    }
}
