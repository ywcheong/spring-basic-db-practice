package com.ywcheong.test.simpledatabase.controller;

import com.ywcheong.test.simpledatabase.data.dto.ChangeProductNameDto;
import com.ywcheong.test.simpledatabase.data.dto.ProductRequestDTO;
import com.ywcheong.test.simpledatabase.data.dto.ProductResponseDTO;
import com.ywcheong.test.simpledatabase.service.impl.DefaultProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.type.NullType;

@RestController("/product")
public class ProductController {
    private final DefaultProductService productService;

    @Autowired
    public ProductController(DefaultProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable("id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProduct(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(requestDTO));
    }

    @PutMapping("/change/name")
    public ResponseEntity<ProductResponseDTO> changeProductName(@RequestBody ChangeProductNameDto dto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.changeProductName(
                    dto.getId(), dto.getName()
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<NullType> deleteProduct(@RequestBody long id){
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
