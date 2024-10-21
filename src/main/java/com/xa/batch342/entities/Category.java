package com.xa.batch342.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "categories")
public class Category extends BaseEntity {

    //can be replace with add @NoArgsConstructor below @Data
    public Category(){

    }

    public Category(String name, String slug, Boolean isDeleted){
        this.name = name;
        this.slug = slug;
        this.isDeleted = isDeleted;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 50, unique=true)
    private String name;

    @Column(name = "slug", length = 50, unique = true)
    private String slug;


    @Column(name="is_deleted")
    private Boolean isDeleted;

    @OneToMany(mappedBy="category", cascade=CascadeType.ALL)
    @JsonBackReference
    List<Product> product;
}
