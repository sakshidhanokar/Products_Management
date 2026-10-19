package edu.productsmanagement.service;

import edu.productsmanagement.dto.request.ProductRequestDto;
import edu.productsmanagement.dto.request.UpdateProductPrice;
import edu.productsmanagement.dto.response.PageResponse;
import edu.productsmanagement.dto.response.ProductResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    //Business Logic Plan

    public ProductResponseDto findProductById(Long id);

    public ProductResponseDto findByNameAndCategory (String name, String category);

    public List<ProductResponseDto> findAllProducts();

    List<ProductResponseDto> searchProduct(String Keyword);

    ProductResponseDto getLatestProduct();

    PageResponse<ProductResponseDto> getProducts(Pageable pageable);

    public ProductResponseDto addProduct(
            ProductRequestDto productRequestDto);

    public ProductResponseDto updateProduct(
            Long id,
            ProductRequestDto productRequestDto);

    public ProductResponseDto updateProductPrice(
            Long id,
            UpdateProductPrice updateProductPrice);

    public void deleteProductById(Long id);


}
