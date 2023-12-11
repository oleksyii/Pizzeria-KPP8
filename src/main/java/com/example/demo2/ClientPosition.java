package com.example.demo2;

public class ClientPosition {
    private int orderId;
    private double layoutX;
    private double layoutY;
    private int cashierId;

    public ClientPosition(int orderId, double layoutX, double layoutY, int cashierId) {
        this.orderId = orderId;
        this.layoutX = layoutX;
        this.layoutY = layoutY;
        this.cashierId = cashierId;
    }

    // Гетер для поля orderId
    public int getOrderId() {
        return orderId;
    }

    // Сетер для поля orderId
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    // Гетер для поля layoutX
    public double getLayoutX() {
        return layoutX;
    }

    // Сетер для поля layoutX
    public void setLayoutX(double layoutX) {
        this.layoutX = layoutX;
    }

    // Гетер для поля layoutY
    public double getLayoutY() {
        return layoutY;
    }

    // Сетер для поля layoutY
    public void setLayoutY(double layoutY) {
        this.layoutY = layoutY;
    }

    public int getCashierId() {
        return cashierId;
    }

    // Сетер для поля cashierId
    public void setCashierId(int cashierId) {
        this.cashierId = cashierId;
    }
}
