package pl.edu.wszib.labordersspring.rest.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public class OrderCreateDto {
    private final List<Position> positions;

    @JsonCreator
    public OrderCreateDto(@JsonProperty("positions") List<Position> positions) {
        this.positions = positions;
    }

    public static class Position {
        private final Integer quantity;
        private final Item item;

        @JsonCreator
        public Position(@JsonProperty("quantity") Integer quantity,
                        @JsonProperty("item") Item item) {
            this.quantity = quantity;
            this.item = item;
        }

        public static class Item {
            private final String name;
            private final BigDecimal price;
            private final Integer stock;

            @JsonCreator
            public Item(@JsonProperty("name") String name,
                        @JsonProperty("price") BigDecimal price,
                        @JsonProperty("stock") Integer stock) {
                this.name = name;
                this.price = price;
                this.stock = stock;
            }
        }
    }
}
