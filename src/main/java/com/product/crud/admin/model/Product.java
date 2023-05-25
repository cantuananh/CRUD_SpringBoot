package com.product.crud.admin.model;


import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = false, length = 100, name = "name")
    private String name;

    @Column(nullable = false, unique = false, length = 255, name = "product_detail")
    private String productDetail;

    @Column(nullable = false, unique = false)
    private double price;

    @Column(nullable = false, unique = false, length = 255)
    private String manufacturer;


    public Product() {
    }
}
