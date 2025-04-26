package com.betrybe.product.service;

import com.betrybe.product.entity.Product;
import com.betrybe.product.repository.ProductRepository;
import com.betrybe.product.service.exception.ProductNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product findById(Long id) throws ProductNotFoundException {
    return productRepository.findById(id)
        .orElseThrow(ProductNotFoundException::new);
  }

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public Product create(Product product) {
    return productRepository.save(product);
  }

  public Product update(Long id, Product product) throws ProductNotFoundException {
    Product productFromDb = findById(id);

    productFromDb.setName(product.getName());
    productFromDb.setPrice(product.getPrice());

    return productRepository.save(productFromDb);
  }

  public Product deleteById(Long id) throws ProductNotFoundException {
    Product product = findById(id);

    productRepository.deleteById(id);

    return product;
  }
}
