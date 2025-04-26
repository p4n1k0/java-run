package com.betrybe.product.controller;

import com.betrybe.product.controller.dto.ProductCreationDto;
import com.betrybe.product.controller.dto.ProductDto;
import com.betrybe.product.entity.Product;
import com.betrybe.product.service.ProductService;
import com.betrybe.product.service.exception.ProductNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/{id}")
  public ProductDto getProductById(@PathVariable Long id) throws ProductNotFoundException {
    return ProductDto.fromEntity(
        productService.findById(id)
    );
  }

  @GetMapping
  public List<ProductDto> getAllProducts() {
    List<Product> allProducts = productService.findAll();
    return allProducts.stream()
        .map(ProductDto::fromEntity)
        .toList();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProductDto createProduct(@RequestBody ProductCreationDto productCreationDto) {
    return ProductDto.fromEntity(
        productService.create(productCreationDto.toEntity())
    );
  }

  @PutMapping("/{id}")
  public ProductDto updateProduct(@PathVariable Long id,
      @RequestBody ProductCreationDto productCreationDto) throws ProductNotFoundException {
    return ProductDto.fromEntity(
        productService.update(id, productCreationDto.toEntity())
    );
  }

  @DeleteMapping("/{id}")
  public ProductDto deleteProductById(@PathVariable Long id) throws ProductNotFoundException {
    return ProductDto.fromEntity(
        productService.deleteById(id)
    );
  }
}
