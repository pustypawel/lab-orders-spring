package pl.edu.wszib.labordersspring.order;

import pl.edu.wszib.labordersspring.order.jpa.PositionEntity;
import pl.edu.wszib.labordersspring.rest.api.OrderCreateDto;
import pl.edu.wszib.labordersspring.rest.api.OrderDto;

import java.math.BigDecimal;

public class Item {
    private final String name;
    private final BigDecimal price;
    private final Integer stock;

    public Item(String name, BigDecimal price, Integer stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Item(OrderCreateDto.Position.Item item) {
        this.name = item.getName();
        this.price = item.getPrice();
        this.stock = item.getStock();
    }

    public Integer getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    public OrderDto.Position.Item toDto() {
        return new OrderDto.Position.Item(name, price, stock);
    }

    public static Item fromEntity(PositionEntity positionEntity) {
        return new Item(positionEntity.getItemName(), positionEntity.getItemPrice(), positionEntity.getItemStock());
    }
}
