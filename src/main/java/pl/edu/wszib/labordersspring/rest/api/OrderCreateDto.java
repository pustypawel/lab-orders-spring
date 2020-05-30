package pl.edu.wszib.labordersspring.rest.api;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.beans.ConstructorProperties;
import java.math.BigDecimal;
import java.util.List;

public class OrderCreateDto {
    @NotEmpty
    private final List<@Valid Position> positions;

    @ConstructorProperties("positions")
    public OrderCreateDto(List<Position> positions) {
        this.positions = positions;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public static class Position {
        @NotNull
        @Positive
        private final Integer quantity;
        @NotNull
        @Valid
        private final Item item;

        @ConstructorProperties({"quantity", "item"})
        public Position(Integer quantity,
                        Item item) {
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
            @NotBlank
            private final String name;
            @NotNull
            @Positive
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
