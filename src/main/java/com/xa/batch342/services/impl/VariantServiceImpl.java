package com.xa.batch342.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xa.batch342.entities.Variant;
import com.xa.batch342.repositories.VariantRepository;
import com.xa.batch342.services.VariantService;

@Service
public class VariantServiceImpl implements VariantService{
    @Autowired
    VariantRepository variantRepository;

    @Override
    public List<Variant> getAllVariants() {
        return variantRepository.getAllVariants();
    }

    @Override
    public Variant saveVariant(Variant variant) {
        return variantRepository.save(variant);
    }

    
    @Override
    public Variant getVariantById(Long id){
        return variantRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteVariantById(Long id){
        Variant variant = variantRepository.findById(id).orElse(null);
        variantRepository.deleteById(variant.getId());
    }
    @Override
    public List<Variant> getVariantsByIds(List<Long> id){
        return variantRepository.getVariantsByIds(id);
    }
}
