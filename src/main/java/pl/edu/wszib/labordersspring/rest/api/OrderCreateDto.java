package pl.edu.wszib.labordersspring.rest.api;

import java.math.BigDecimal;
import java.util.List;

public class OrderCreateDto {
    private List<Position> positions;

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public static class Position {
        private Integer quantity;
        private Item item;

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        public static class Item {
            private String name;
            private BigDecimal price;
            private Integer stock;

            public Item(String name, BigDecimal price, Integer stock) {
                this.name = name;
                this.price = price;
                this.stock = stock;
            }
        }
    }
}
