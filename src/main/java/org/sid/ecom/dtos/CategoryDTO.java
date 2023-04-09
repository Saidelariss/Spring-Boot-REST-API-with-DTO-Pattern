package org.sid.ecom.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.ecom.entities.Product;

import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
//Dans une classe DTO, on ne met que les informations dont nous aurons besoin dans le frontend
public class CategoryDTO {
    private Long id;
    private String name;

}
