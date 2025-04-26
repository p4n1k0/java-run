package com.betrybe.product.controller.dto;

import com.betrybe.product.entity.Brand;

public record BrandDto(Long id, String name) {

  public static BrandDto fromEntity(Brand brand) {
    return new BrandDto(
        brand.getId(),
        brand.getName()
    );
  }
}
