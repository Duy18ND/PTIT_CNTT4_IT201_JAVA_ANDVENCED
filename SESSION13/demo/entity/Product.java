package SESSION13.demo.entity;

import java.util.Date;

public class Product {
    private Integer product_id;
    private String product_name;
    private String producer;
    private Date expire_date;
    private Double price;


    private Category category;

    public Product(){}

    public Product(Integer product_id, String product_name, String producer, Date expire_date, Double price, Category category) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.producer = producer;
        this.expire_date = expire_date;
        this.price = price;
        this.category = category;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        String cateName = (category != null && category.getCate_name() != null)
                ? category.getCate_name()
                : "Chưa phân loại";
        String expireStr = (expire_date != null)
                ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(expire_date)
                : "Không có";

        return String.format("ID: %-5d | Tên SP: %-25s | Hãng: %-15s | HSD: %-10s | Giá: %-,12.2f | Danh mục: %s",
                product_id,
                product_name,
                producer,
                expireStr,
                price,
                cateName);
    }
}
