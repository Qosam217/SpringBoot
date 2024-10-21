package com.xa.batch342.services;

import java.util.List;

import com.xa.batch342.entities.Variant;

public interface VariantService {
    List<Variant> getAllVariants();
    List<Variant> getVariantsByIds(List<Long> id);
    Variant saveVariant(Variant variant);
    Variant getVariantById(Long id);
    void deleteVariantById(Long id);

}
