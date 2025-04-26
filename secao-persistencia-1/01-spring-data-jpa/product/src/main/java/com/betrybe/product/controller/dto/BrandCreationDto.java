package com.betrybe.product.controller.dto;

import com.betrybe.product.entity.Brand;

public record BrandCreationDto(String name) {

  public Brand toEntity() {
    return new Brand(name);
  }
}
