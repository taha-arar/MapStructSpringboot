package mapstruct.springboot.controller;


import lombok.AllArgsConstructor;
import mapstruct.springboot.converter.ProductMapper;
import mapstruct.springboot.dto.ProductDTO;
import mapstruct.springboot.model.Product;
import mapstruct.springboot.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@RequestBody ProductDTO productDTO){

        return new ResponseEntity<>
                (productRepository.save(productMapper.from(productDTO)), HttpStatus.CREATED);

    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return new ResponseEntity<>
                (productMapper.ListTo(productRepository.findAll()),HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(productMapper.to(productRepository.findById(id).get()),HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<ProductDTO> deleteById(@PathVariable("id") Long id){
        ProductDTO productDTO = productMapper.to(productRepository.findById(id).get());
        productRepository.deleteById(productDTO.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
