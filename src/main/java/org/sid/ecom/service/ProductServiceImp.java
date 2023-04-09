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
        /* Pour faire le mapping entre les entités JPA et les DTOs, le code le plus basique à écrire correspond à ceci
            (mais ce n'est pas pratique, c'est la raison pour laquelle on fait appel au mapper).
        Product product=new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(product.getQuantity());

        Category category=new Category();
        category.setId(productDTO.getCategory().getId());
        category.setName(productDTO.getCategory().getName());
        product.setCategory(category);

        return productRepository.save(product);
    }  */

        //mapper :
        Product product= catalogMappers.fromProductDTO(productDTO);
        //UUID.randomUUID().toString() génère des chaines de caractères de manière unique
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

