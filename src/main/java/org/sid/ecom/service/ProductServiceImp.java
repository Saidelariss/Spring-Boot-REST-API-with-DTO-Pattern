package org.sid.ecom.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.sid.ecom.dtos.CategoryDTO;
import org.sid.ecom.dtos.ProductDTO;
import org.sid.ecom.entities.Category;
import org.sid.ecom.entities.Product;
import org.sid.ecom.mappers.CatalogMappers;
import org.sid.ecom.respositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImp implements ProductService{
    private ProductRepository productRepository;

    private CatalogMappers catalogMappers;


    public ProductDTO save(ProductDTO productDTO) {
      /*  Product product=new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(product.getQuantity());

        Category category=new Category();
        category.setId(productDTO.getCategory().getId());
        category.setName(productDTO.getCategory().getName());
        product.setCategory(category);

        return productRepository.save(product);
    }

       */

        Product product= catalogMappers.fromProductDTO(productDTO);
        product.setId(UUID.randomUUID().toString());
        Product savedProduct =  productRepository.save(product);
        return catalogMappers.fromProduct(savedProduct);

    }

    public List<ProductDTO> listProduct(){
        List<Product> products=productRepository.findAll();
        List<ProductDTO> productDTOS=
                products.stream().map(p->catalogMappers.fromProduct(p))
                        .collect(Collectors.toList());
        return productDTOS;
    }
}

