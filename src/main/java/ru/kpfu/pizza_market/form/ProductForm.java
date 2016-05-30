package ru.kpfu.pizza_market.form;

import java.io.Serializable;

/**
 * Created by Anvar on 18.05.16.
 */
public class ProductForm implements Serializable {

    private String name;

    private String description;

    private Integer price;

    private Integer weight;

    private Integer diameterSize;

    private String img;

    private Long categoryId;

    public ProductForm() {
    }

    public ProductForm(String name, String description, Integer price, Integer weight, Integer diameterSize, String img, Long categoryId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.diameterSize = diameterSize;
        this.img = img;
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getDiameterSize() {
        return diameterSize;
    }

    public void setDiameterSize(Integer diameterSize) {
        this.diameterSize = diameterSize;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
