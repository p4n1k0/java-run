package com.betrybe.product.service;

import com.betrybe.product.entity.Brand;
import com.betrybe.product.repository.BrandRepository;
import com.betrybe.product.service.exception.BrandNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

  private final BrandRepository brandRepository;

  @Autowired
  public BrandService(BrandRepository brandRepository) {
    this.brandRepository = brandRepository;
  }

  public Brand findById(Long id) throws BrandNotFoundException {
    return brandRepository.findById(id)
        .orElseThrow(BrandNotFoundException::new);
  }

  public List<Brand> findAll() {
    return brandRepository.findAll();
  }

  public Brand create(Brand brand) {
    return brandRepository.save(brand);
  }

  public Brand update(Long id, Brand brand) throws BrandNotFoundException {
    Brand brandFromDb = findById(id);

    brandFromDb.setName(brand.getName());

    return brandRepository.save(brandFromDb);
  }

  public Brand deleteById(Long id) throws BrandNotFoundException {
    Brand brand = findById(id);

    brandRepository.deleteById(id);

    return brand;
  }
}
