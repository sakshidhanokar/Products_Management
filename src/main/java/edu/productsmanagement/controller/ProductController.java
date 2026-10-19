package edu.productsmanagement.controller;

import edu.productsmanagement.dto.request.ProductRequestDto;
import edu.productsmanagement.dto.request.UpdateProductPrice;
import edu.productsmanagement.dto.response.ApiResponseDto;
import edu.productsmanagement.dto.response.ProductResponseDto;
import edu.productsmanagement.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//https://localhost:8081/api/v1/productss


@RestController
@RequestMapping("api/v1/productss")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<ProductResponseDto>> findProductById(
            //URL मधून value घेण्यासाठी @PathVariable वापरतो.
            @PathVariable
            Long id,
            HttpServletRequest request

    ){
        return ResponseEntity.ok(
                ApiResponseDto.success(
                        "product fetched successfully",
                        HttpStatus.OK.value(),
                        productService.findProductById(id),
                        request.getRequestURI()
                )
        );
    }

    @GetMapping
    //https://localhost:8081/api/v1/productss
    public ApiResponseDto<?> findAllProducts(
            HttpServletRequest request
    ) {
        return ApiResponseDto.success(
                "Products fetched successfully",
                HttpStatus.OK.value(),
                productService.findAllProducts(),
                request.getRequestURI()
        );
    }

    @GetMapping("/name-and-category")
    public ApiResponseDto<ProductResponseDto> findByNameAndCategory(
            @RequestParam
            @NotBlank(message = "name is required")
            String name,

            @RequestParam
            @NotBlank(message = "category is required")
            String category,

            HttpServletRequest request
    ) {
        return ApiResponseDto.success(
                "Product fetched successfully",
                HttpStatus.OK.value(),
                productService.findByNameAndCategory(name, category),
                request.getRequestURI()
        );
    }

    @GetMapping("/search")
    public ApiResponseDto<List<ProductResponseDto>> searchProduct(
            @RequestParam
            String keyword,

            HttpServletRequest request
    ) {
        return ApiResponseDto.success(
                "Products searched successfully",
                HttpStatus.OK.value(),
                productService.searchProduct(keyword),
                request.getRequestURI()
        );
    }


    @GetMapping("/latest")
    public ApiResponseDto<ProductResponseDto> getLatestProduct(
            HttpServletRequest request
    ) {
        return ApiResponseDto.success(
                "Latest product fetched successfully",
                HttpStatus.OK.value(),
                productService.getLatestProduct(),
                request.getRequestURI()
        );
    }

    @GetMapping("/list")
    ResponseEntity<?>getProducts(


            @ParameterObject
            @PageableDefault(
                    size = 2,
                    page = 0,
                    sort = "name",
                    direction = Sort.Direction.ASC
            )
            Pageable pageable
    ){
        return ResponseEntity.ok(
                productService.getProducts(pageable)
        );
    }

    @PostMapping
    public ResponseEntity<?> addProduct(
            @RequestBody //Client कडून आलेला JSON data Java object मध्ये convert कर.
            @Valid       //it will enable our validation
            // @Valid चा उपयोग validation करण्यासाठी होतो.
            ProductRequestDto productRequestDto,

            HttpServletRequest request
    ) {
//        return productService.addProduct(productRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED.value())
                .body(
                        ApiResponseDto.success(
                                "Product added successfully",
                                HttpStatus.CREATED.value(),
                                productService.addProduct(productRequestDto),
                                request.getRequestURI()
                        )
                );
    }


    @PutMapping("/{id}")
    public ApiResponseDto<ProductResponseDto> updateProduct(
            @PathVariable
            Long id,

            @RequestBody
            @Valid
            ProductRequestDto productRequestDto,

            HttpServletRequest request
    ) {
        return ApiResponseDto.success(
                "Product updated successfully",
                HttpStatus.OK.value(),
                productService.updateProduct(id, productRequestDto),
                request.getRequestURI()
        );
    }


    @PatchMapping("/{id}")
    public ApiResponseDto<ProductResponseDto> updateProductPrice(
            @PathVariable
            Long id,

            @RequestBody
            @Valid
            UpdateProductPrice updateProductPrice,

            HttpServletRequest request
    ) {
        return ApiResponseDto.success(
                "Product price updated successfully",
                HttpStatus.OK.value(),
                productService.updateProductPrice(id, updateProductPrice),
                request.getRequestURI()
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(
            @PathVariable
            Long id,

            HttpServletRequest request
    ) {
        productService.deleteProductById(id);

        return ResponseEntity.noContent().build();
    }


}
