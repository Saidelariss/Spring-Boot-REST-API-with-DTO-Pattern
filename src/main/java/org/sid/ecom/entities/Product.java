package org.sid.ecom.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
//Entité JPA
public class Product {
    @Id
    private String id;
    private String name;
    private double price;
    private double quantity;
    @ManyToOne
    private Category category;


}
