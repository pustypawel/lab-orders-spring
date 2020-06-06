package pl.edu.wszib.labordersspring.order.jpa;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Positions")
public class PositionEntity {
    @ManyToOne(optional = false)
    private OrderEntity order;

    @Id
    private Long id;

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

    public PositionEntity(Long id,
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
}
