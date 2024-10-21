package com.xa.batch342.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Product extends BaseEntity{

    public Product(String name, String slug, Long categoryId, Boolean isDeleted){
        this.name = name;
        this.slug = slug;
        this.categoryId = categoryId;
        this.isDeleted = isDeleted;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 50, unique=true)
    private String name;

    @Column(name = "slug", length = 50, unique = true)
    private String slug;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    @JsonManagedReference
    public Category category;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @OneToMany(mappedBy="product", cascade=CascadeType.ALL)
    @JsonBackReference
    List<Variant> variant;
    
}
