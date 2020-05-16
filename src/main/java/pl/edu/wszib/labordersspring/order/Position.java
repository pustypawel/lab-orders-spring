package pl.edu.wszib.labordersspring.order;

import pl.edu.wszib.labordersspring.rest.api.OrderCreateDto;
import pl.edu.wszib.labordersspring.rest.api.OrderDto;

public class Position {
    private Integer quantity;
    private final Item item;

    public Position(Integer quantity, Item item) {
        this.quantity = quantity;
        this.item = item;
    }

    public Position(OrderCreateDto.Position position) {
        this.quantity = position.getQuantity();
        this.item = new Item(position.getItem());
    }

    public void increaseQuantity() {
        quantity = quantity + 1;
    }

    public void decreaseQuantity() {
        if (quantity > 1) {
            quantity = quantity - 1;
        } else {
            throw new IllegalStateException("quantity has to be greater than 1. quantity = " + quantity);
        }
    }

    public void setQuantity(Integer newQuantity) {
        if (newQuantity > 0) {
            quantity = newQuantity;
        } else {
            throw new IllegalArgumentException("quantity has to be greater than 0. quantity = " + quantity);
        }
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Position{" +
                "quantity=" + quantity +
                ", item=" + item +
                '}';
    }

    public OrderDto.Position toDto() {
        return new OrderDto.Position(quantity, item.toDto());
    }
}
