package SESSION11.Demo.entity;

import java.util.Date;

public class Product {
    private Integer proId;
    private String proName;
    private String producer;
    private Integer year_making;
    private Date expiryDate; // Đã sửa chính tả
    private Double price;

    public Product() {}

    public Product(Integer proId, String proName, String producer, Integer year_making, Date expiryDate, Double price) {
        this.proId = proId;
        this.proName = proName;
        this.producer = producer;
        this.year_making = year_making;
        this.expiryDate = expiryDate;
        this.price = price;
    }

    // Getters and Setters
    public Integer getProId() { return proId; }
    public void setProId(Integer proId) { this.proId = proId; }

    public String getProName() { return proName; }
    public void setProName(String proName) { this.proName = proName; }

    public String getProducer() { return producer; }
    public void setProducer(String producer) { this.producer = producer; }

    public Integer getYear_making() { return year_making; }
    public void setYear_making(Integer year_making) { this.year_making = year_making; }

    public Date getExpiryDate() { return expiryDate; }
    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    @Override
    public String toString() {
        return String.format("ID: %d | Tên: %-15s | NSX: %-10s | Năm: %d | HSD: %s | Giá: %,.0f VNĐ",
                proId, proName, producer, year_making, expiryDate, price);
    }
}