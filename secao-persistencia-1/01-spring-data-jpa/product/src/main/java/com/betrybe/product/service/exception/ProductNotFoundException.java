package com.betrybe.product.service.exception;

public class ProductNotFoundException extends NotFoundException{

  public ProductNotFoundException() {
    super("Produto não encontrado!");
  }
}
