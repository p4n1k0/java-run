package com.betrybe.product.service.exception;

public class BrandNotFoundException extends NotFoundException {

  public BrandNotFoundException() {
    super("Brand não encontrada!");
  }
}
