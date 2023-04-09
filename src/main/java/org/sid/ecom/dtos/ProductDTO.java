package org.sid.ecom.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.ecom.entities.Category;


@Data @AllArgsConstructor @NoArgsConstructor
//Dans une classe DTO, on ne met que les informations dont nous aurons besoin dans le frontend
public class ProductDTO {

    private String id;
    private String name;
    private double price;
    private double quantity;
    private CategoryDTO categoryDTO;



}
