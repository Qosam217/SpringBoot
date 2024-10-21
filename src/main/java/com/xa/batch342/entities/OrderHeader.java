package com.xa.batch342.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import groovy.transform.EqualsAndHashCode;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@Table(name="orders_header")
@NoArgsConstructor
public class OrderHeader extends BaseEntity{
    
    public OrderHeader(BigDecimal amount, Boolean isDeleted){
        this.amount = amount;
        this.isDeleted = isDeleted;
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMM");
        this.referee = "SLS-" + date.format(formatter) + "-";
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="referee", length=15)
    private String referee;

    @Column(name="amount", precision=18, scale=4)
    private BigDecimal amount;

    @Column(name="isDeleted")
    private Boolean isDeleted;

    @OneToMany(mappedBy="orderHeader", cascade=CascadeType.ALL)
    @JsonBackReference
    List<OrderDetail> orderDetail;
}
