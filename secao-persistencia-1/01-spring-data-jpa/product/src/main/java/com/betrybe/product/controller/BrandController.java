package com.betrybe.product.controller;

import com.betrybe.product.controller.dto.BrandCreationDto;
import com.betrybe.product.controller.dto.BrandDto;
import com.betrybe.product.entity.Brand;
import com.betrybe.product.service.BrandService;
import com.betrybe.product.service.exception.BrandNotFoundException;
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
@RequestMapping(value = "/brands")
public class BrandController {

  private final BrandService brandService;

  @Autowired
  public BrandController(BrandService brandService) {
    this.brandService = brandService;
  }

  @GetMapping("/{id}")
  public BrandDto getBrandById(@PathVariable Long id) throws BrandNotFoundException {
    return BrandDto.fromEntity(
        brandService.findById(id)
    );
  }

  @GetMapping
  public List<BrandDto> getAllBrands() {
    List<Brand> allBrands = brandService.findAll();
    return allBrands.stream()
        .map(BrandDto::fromEntity)
        .toList();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BrandDto createBrand(@RequestBody BrandCreationDto brandCreationDto) {
    return BrandDto.fromEntity(
        brandService.create(brandCreationDto.toEntity())
    );
  }

  @PutMapping("/{id}")
  public BrandDto updateBrand(@PathVariable Long id,
      @RequestBody BrandCreationDto brandCreationDto) throws BrandNotFoundException {
    return BrandDto.fromEntity(
        brandService.update(id, brandCreationDto.toEntity())
    );
  }

  @DeleteMapping("/{id}")
  public BrandDto deleteBrandById(@PathVariable Long id) throws BrandNotFoundException {
    return BrandDto.fromEntity(
        brandService.deleteById(id)
    );

  }
}
