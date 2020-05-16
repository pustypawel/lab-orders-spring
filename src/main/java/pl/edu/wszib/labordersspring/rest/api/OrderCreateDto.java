package pl.edu.wszib.labordersspring.rest.api;

import java.beans.ConstructorProperties;
import java.math.BigDecimal;
import java.util.List;

public class OrderCreateDto {
    private final List<Position> positions;

    @ConstructorProperties("positions")
    public OrderCreateDto(List<Position> positions) {
        this.positions = positions;
    }

    public static class Position {
        private final Integer quantity;
        private final Item item;

        @ConstructorProperties({"quantity", "item"})
        public Position(Integer quantity,
                        Item item) {
            this.quantity = quantity;
            this.item = item;
        }

        public static class Item {
            private final String name;
            private final BigDecimal price;
            private final Integer stock;

            @ConstructorProperties({"name", "price", "stock"})
            public Item(String name,
                        BigDecimal price,
                        Integer stock) {
                this.name = name;
                this.price = price;
                this.stock = stock;
            }
        }
    }
}
