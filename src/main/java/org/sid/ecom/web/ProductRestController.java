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
     //Spring utilisera Jackson pour sérialiser cette instance en JSON et renvoyer la réponse au client
    }

    @GetMapping(path="/products/{id}")
    public Product getProducts(@PathVariable(name = "id") String id){
        return productRepository.findById(id).get();
    }

    //ajout
    @PostMapping(path="/products")
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO){
        return productService.save(productDTO);
        /*product.setId(UUID.randomUUID().toString());
        return productRepository.save(product);*/
    }

    //Mise à jour
    @PutMapping(path="/products/{id}")
    public Product updateProduct(@RequestBody Product product,@PathVariable String id){
        product.setId(id);
        return productRepository.save(product);
    }

    @DeleteMapping(path="/products/{id}")
    public void updateProduct(@PathVariable String id){
      productRepository.deleteById(id);
    }

}
