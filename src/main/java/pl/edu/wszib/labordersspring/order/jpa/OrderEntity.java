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
                       Boolean isClosed) {
        this.id = id;
        this.isClosed = isClosed;
    }
}
