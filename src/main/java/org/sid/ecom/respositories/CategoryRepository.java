package org.sid.ecom.respositories;

import org.sid.ecom.entities.Category;
import org.sid.ecom.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
