package 第二章_集合框架;

public class Wine{
    private String brand;//品牌
    private double price;//价格
    private double rest;//剩余量

    public Wine(String brand, double price, double rest) {
        this.brand = brand;
        this.price = price;
        this.rest = rest;
    }

    @Override
    public String toString() {
        return String.format("%s",brand);
    }
}