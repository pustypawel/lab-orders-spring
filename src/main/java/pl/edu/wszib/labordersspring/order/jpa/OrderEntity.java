package pl.edu.wszib.labordersspring.order.jpa;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class OrderEntity {
    @Id
    private String id;

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
