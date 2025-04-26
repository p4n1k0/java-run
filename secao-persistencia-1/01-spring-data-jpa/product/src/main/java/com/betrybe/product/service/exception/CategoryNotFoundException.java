package com.betrybe.product.service.exception;

public class CategoryNotFoundException extends NotFoundException{

  public CategoryNotFoundException() {
    super("Categoria não encontrada!");
  }
}
