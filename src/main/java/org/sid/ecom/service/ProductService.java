package org.sid.ecom.service;

import org.sid.ecom.dtos.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO save(ProductDTO productDTO);
    List<ProductDTO> listProduct();
}
