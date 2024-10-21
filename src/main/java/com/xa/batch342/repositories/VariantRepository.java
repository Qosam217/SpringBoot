package com.xa.batch342.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xa.batch342.entities.Variant;

@Repository
public interface  VariantRepository extends JpaRepository<Variant, Long>{
    @Query(value = "select v from Variant v join v.product p join p.category c where v.isDeleted = false and p.isDeleted = false and c.isDeleted = false")
    List<Variant> getAllVariants();

    @Query(value = "select v from Variant v join v.product p join p.category c where v.isDeleted = false and p.isDeleted = false and c.isDeleted = false and v.id in :ids")
    List<Variant> getVariantsByIds(@Param("ids") List<Long> ids);
}
