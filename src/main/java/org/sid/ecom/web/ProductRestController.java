package org.sid.ecom.web;

import lombok.AllArgsConstructor;
import org.sid.ecom.dtos.ProductDTO;
import org.sid.ecom.entities.Product;
import org.sid.ecom.respositories.ProductRepository;
import org.sid.ecom.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class ProductRestController {
    ProductRepository productRepository;

    ProductService productService;

    //consultation
    @GetMapping(path="/products")
    public List<ProductDTO> productList(){
        return productService.listProduct();
     //Spring utilisera implicitement la bibliothèque Jackson pour sérialiser les objets java en JSON
    //Ce sont juste les DTO qui seront sérialisés en format json et non pas les entités jpa
    }


    //ajout
    @PostMapping(path="/products")
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO){
        return productService.save(productDTO);
        /*product.setId(UUID.randomUUID().toString());
        return productRepository.save(product);*/
    }


}
