package com.cy.t;

import java.util.List;

/**
 * @ClassName category
 * @Description TODD
 * @Author BigPig
 * @Date 2019/4/25 15:57
 * @Version 1.0
 **/
public class category {
    private int id;
    private String name;
    List<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
