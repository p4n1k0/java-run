package com.betrybe.product.controller.dto;

import com.betrybe.product.entity.Category;

public record CategoryDto(Long id, String name) {

  public static CategoryDto fromEntity(Category category) {
    return new CategoryDto(
        category.getId(),
        category.getName()
    );
  }
}
