package pl.edu.wszib.labordersspring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/orders")
@RestController
public class OrderController {

    @GetMapping
    public String helloOrders() {
        return "Hello orders";
    }
}
