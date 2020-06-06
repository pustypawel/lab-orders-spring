package pl.edu.wszib.labordersspring.order.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaOrderDao extends JpaRepository<OrderEntity, String> {
}
