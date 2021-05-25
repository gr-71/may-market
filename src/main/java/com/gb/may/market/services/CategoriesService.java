package com.gb.may.market.services;

import com.gb.may.market.entities.Category;
import com.gb.may.market.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {
    private CategoriesRepository categoriesRepository;

    @Autowired
    public void setCategoriesRepository(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public List<Category> getAllCategories(){
        return categoriesRepository.findAll();
    }

    public List<Category> getCategoriesByIds(List<Long> ids){
        return categoriesRepository.findAllById(ids);
    }
}
