package com.xa.batch342.entities;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import groovy.transform.EqualsAndHashCode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper=true)
@Data
@Table(name="orders_detail")
@NoArgsConstructor
public class OrderDetail extends BaseEntity{
    
    public OrderDetail(BigDecimal quantity, Long orderHeaderId, Long variantId, BigDecimal price, Boolean isDeleted){
        this.quantity = quantity;
        this.orderHeaderId = orderHeaderId;
        this.variantId = variantId;
        this.price = price;
        this.isDeleted = isDeleted;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="header_id", insertable=false, updatable=false)
    @JsonManagedReference
    private OrderHeader orderHeader;

    @Column(name="header_id")
    private Long orderHeaderId;

    @ManyToOne
    @JoinColumn(name="variant_id", insertable=false, updatable=false)
    @JsonManagedReference
    private Variant variant;

    @Column(name="variant_id")
    private Long variantId;

    @Column(name="quantity", precision=18, scale=4)
    private BigDecimal quantity;

    @Column(name="price", precision=18, scale=4)
    private BigDecimal price;

    @Column(name="is_deleted")
    private Boolean isDeleted;
}
