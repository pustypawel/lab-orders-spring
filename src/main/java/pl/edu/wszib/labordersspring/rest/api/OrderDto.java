package pl.edu.wszib.labordersspring.rest.api;

import java.math.BigDecimal;
import java.util.List;

public class OrderDto {
    private final String id;
    private final List<Position> positions;
    private final boolean isClosed;

    public OrderDto(String id, List<Position> positions, boolean isClosed) {
        this.id = id;
        this.positions = positions;
        this.isClosed = isClosed;
    }

    public String getId() {
        return id;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public static class Position {
        private final Integer quantity;
        private final Item item;

        public Position(Integer quantity, Item item) {
            this.quantity = quantity;
            this.item = item;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public Item getItem() {
            return item;
        }

        public static class Item {
            private final String name;
            private final BigDecimal price;
            private final Integer stock;

            public Item(String name, BigDecimal price, Integer stock) {
                this.name = name;
                this.price = price;
                this.stock = stock;
            }

            public String getName() {
                return name;
            }

            public BigDecimal getPrice() {
                return price;
            }

            public Integer getStock() {
                return stock;
            }
        }
    }
}
