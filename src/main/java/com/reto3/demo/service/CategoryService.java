package com.reto3.demo.service;


import java.util.List;
import java.util.Optional;
import com.reto3.demo.model.Category;
import com.reto3.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category catg) {
        if (catg.getId() == null) {
            return categoryRepository.save(catg);
        } else {
            Optional<Category> consulta = categoryRepository.getCategory(catg.getId());
            if (consulta.isEmpty()) {
                return categoryRepository.save(catg);
            } else {
                return catg;

            }
        }
    }

}
