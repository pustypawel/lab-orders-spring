package pl.edu.wszib.labordersspring.order;

import pl.edu.wszib.labordersspring.order.jpa.OrderEntity;
import pl.edu.wszib.labordersspring.order.jpa.PositionEntity;
import pl.edu.wszib.labordersspring.rest.api.OrderCreateDto;
import pl.edu.wszib.labordersspring.rest.api.OrderDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class Order {
    private String id;

    private final List<Position> positions = new ArrayList<>();
    private boolean isClosed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Order() {
    }

    public Order(List<OrderCreateDto.Position> positions) {
        this.id = null;
        List<Position> mappedPositions = positions.stream()
                .map(Position::new).collect(Collectors.toList());
        this.positions.addAll(mappedPositions);
        this.isClosed = false;
    }

    private Order(String id,
                 List<Position> positions,
                 boolean isClosed) {
        this.id = id;
        this.positions.addAll(positions);
        this.isClosed = isClosed;
    }

    public void addPosition(Position position) {
        validateIsNotClosed();
        positions.add(position);
    }

    public int positionsCount() {
        return positions.size();
    }

    public void removePosition(int line) {
        validateIsModifiable(line);
        positions.remove(line - 1);
    }

    private void validateIsNotClosed() {
        if (isClosed) {
            throw new IllegalStateException("Order is already closed");
        }
    }

    private void validateLine(int line) {
        if (line <= 0) {
            throw new IllegalArgumentException("line should be grader than 0. line = " + line);
        }
        if (line > positions.size()) {
            throw new IllegalArgumentException("line should be less than " + positions.size() + ". line = " + line);
        }
    }

    public BigDecimal calculateSum() {
        BigDecimal sum = new BigDecimal(0);
        for (Position position : positions) {
            Item item = position.getItem();
            BigDecimal price = item.getPrice();
            Integer quantity = position.getQuantity();
            sum = sum.add(price.multiply(new BigDecimal(quantity)));
        }
        return sum;
    }

    public void close() {
        isClosed = true;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void increasePositionQuantity(int line) {
        validateIsModifiable(line);
        Position position = positions.get(line - 1);
        position.increaseQuantity();
    }

    public Integer getPositionQuantity(int line) {
        return positions.get(line - 1).getQuantity();
    }

    public void decreasePositionQuantity(int line) {
        validateIsModifiable(line);
        Position position = positions.get(line - 1);
        position.decreaseQuantity();
    }

    public void setPositionQuantity(int line, Integer newQuantity) {
        validateLine(line);
        Position position = positions.get(line - 1);
        position.setQuantity(newQuantity);
    }

    private void validateIsModifiable(int line) {
        validateIsNotClosed();
        validateLine(line);
    }

    public boolean hasPosition(Position position) {
        return positions.contains(position);
    }

    public String getDescription() {
        return toString();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", positions=" + positions +
                ", isClosed=" + isClosed +
                '}';
    }

    public OrderDto toDto() {
        List<OrderDto.Position> mappedPositions = positions.stream()
                .map(Position::toDto)
                .collect(Collectors.toList());
        return new OrderDto(id, mappedPositions, isClosed);
    }

    public OrderEntity toEntity() {
        AtomicLong counter = new AtomicLong();
        List<PositionEntity> mappedPositions = positions.stream()
                .map(position -> position.toEntity(id + "_" + counter.incrementAndGet()))
                .collect(Collectors.toList());
        return new OrderEntity(id, mappedPositions, isClosed);
    }

    public static Order fromEntity(OrderEntity orderEntity) {
        List<Position> positions = orderEntity.getPositions().stream()
                .map(Position::fromEntity)
                .collect(Collectors.toList());
        return new Order(orderEntity.getId(), positions, orderEntity.getClosed());
    }
}
