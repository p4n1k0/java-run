package com.betrybe.product.controller.dto;

import com.betrybe.product.entity.Category;

public record CategoryCreationDto(String name) {

  public Category toEntity() {
    return new Category(name);
  }
}
