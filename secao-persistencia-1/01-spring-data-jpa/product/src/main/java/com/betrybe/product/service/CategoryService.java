package com.betrybe.product.service;

import com.betrybe.product.entity.Category;
import com.betrybe.product.repository.CategoryRepository;
import com.betrybe.product.service.exception.CategoryNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;

  @Autowired
  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public Category findById(Long id) throws CategoryNotFoundException {
    return categoryRepository.findById(id)
        .orElseThrow(CategoryNotFoundException::new);
  }

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public Category create(Category category) {
    return categoryRepository.save(category);
  }

  public Category update(Long id, Category category) throws CategoryNotFoundException {
    Category categoryFromDb = findById(id);

    categoryFromDb.setName(category.getName());

    return categoryRepository.save(categoryFromDb);
  }

  public Category deleteById(Long id) throws CategoryNotFoundException {
    Category category = findById(id);

    categoryRepository.deleteById(id);

    return category;
  }
}
