package pl.edu.wszib.labordersspring.order.jpa;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Orders")
public class OrderEntity {
    @Id
    private String id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "order")
    private List<PositionEntity> positions;

    @Column(nullable = false)
    private Boolean isClosed;

    public OrderEntity() {
        // for JPA
    }

    public OrderEntity(String id,
                       List<PositionEntity> positions,
                       Boolean isClosed) {
        this.id = id;
        this.positions = positions;
        this.positions.forEach(positionEntity -> positionEntity.setOrder(this));
        this.isClosed = isClosed;
    }
}
