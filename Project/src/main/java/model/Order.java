package model;

import java.time.LocalDate;

import java.util.HashMap;

public class Order {

    private static int orderAmount;

    private final int orderId;
    private final User buyer;
    private HashMap<Product, Integer> orderedProducts;
    private OrderStatus status;
    private final LocalDate dateOfOrder;

    static {
        orderAmount = 0;
    }

    public Order(User buyer) {
        orderId = ++orderAmount;
        this.buyer = buyer;
        status = OrderStatus.CREATED;
        dateOfOrder = LocalDate.now();
        orderedProducts = new HashMap<>();
    }

    public Order(User buyer, HashMap<Product, Integer> orderedProducts) {
        orderId = ++orderAmount;
        this.buyer = buyer;
        status = OrderStatus.CREATED;
        dateOfOrder = LocalDate.now();
        this.orderedProducts = orderedProducts;
    }

    public HashMap<Product, Integer> getOrderedProducts() {
        return orderedProducts;
    }

    public User getBuyer() {
        return buyer;
    }

    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void changeStatus(OrderStatus status) {
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order {orderId: " + orderId +
                ", orderedProducts: " + orderedProducts +
                ", OrderStatus: " + status +
                ", dateOfOrder: " + dateOfOrder +
                '}';
    }
}
