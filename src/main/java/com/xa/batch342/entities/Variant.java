package com.xa.batch342.entities;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import groovy.transform.EqualsAndHashCode;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="variants")
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class Variant extends BaseEntity{

    public Variant(String name, Long productId,String slug, String description, BigDecimal price, BigDecimal stock, Boolean isDeleted){
        this.slug = slug;
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.isDeleted = isDeleted;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    @JsonManagedReference
    private Product product;

    @Column(name="product_id")
    private Long productId;

    @Column(name="slug", unique=true, length=50)
    private String slug;

    @Column(name="name", length=50, unique=true)
    private String name;

    @Column(name="description", length=500)
    private String description;

    @Column(name="price", precision=18, scale=2)
    private BigDecimal price;

    @Column(name="stock", precision=18, scale=2)
    private BigDecimal stock;

    @Column(name="is_deleted")
    private Boolean isDeleted;
    
    @OneToMany(mappedBy="variant", cascade=CascadeType.ALL)
    @JsonBackReference
    List<OrderDetail> orderDetail;
}
