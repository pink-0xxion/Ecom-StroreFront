package com.ecom.productcatalog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category",       //One Category can have many Products.
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)
//    @JsonIgnore
    @JsonBackReference
    private Set<Product> products;

    //explicitly defining getters and setters as lombok is not working
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

/*
mappedBy = "category": Refers to the field in the Product class that owns the relationship (private Category category;).
            It indicates that the Category class does not directly manage the foreign key. Instead, the Product class does.
cascade = CascadeType.ALL: Specifies that operations on a Category (like save, delete) should cascade to its related Products.
            For example, if you delete a category, all its associated products will also be deleted automatically.
fetch = FetchType.LAZY: Means the products list will not be loaded from the database immediately when a Category is retrieved.
            It will only be fetched when accessed (e.g., calling category.getProducts()).
private Set<Product> products: Holds the collection of all products that belong to the category.
*/
