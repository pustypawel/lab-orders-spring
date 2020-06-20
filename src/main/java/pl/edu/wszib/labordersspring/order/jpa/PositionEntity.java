package pl.edu.wszib.labordersspring.order.jpa;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Positions")
public class PositionEntity {
    @ManyToOne(optional = false)
    private OrderEntity order;

    @Id
    private String id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private BigDecimal itemPrice;

    @Column(nullable = false)
    private Integer itemStock;

    public PositionEntity() {
        // for JPA
    }

    public PositionEntity(String id,
                          Integer quantity,
                          String itemName,
                          BigDecimal itemPrice,
                          Integer itemStock) {
        this.id = id;
        this.quantity = quantity;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemStock = itemStock;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public Integer getItemStock() {
        return itemStock;
    }
}
