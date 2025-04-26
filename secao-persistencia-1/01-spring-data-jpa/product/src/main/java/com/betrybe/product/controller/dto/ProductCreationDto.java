package com.betrybe.product.controller.dto;

import com.betrybe.product.entity.Product;

public record ProductCreationDto(String name, Double price) {

  public Product toEntity() {
    return new Product(name, price);
  }
}
