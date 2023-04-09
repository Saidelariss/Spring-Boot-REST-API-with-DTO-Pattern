package org.sid.ecom;

import org.sid.ecom.entities.Category;
import org.sid.ecom.entities.Product;
import org.sid.ecom.respositories.CategoryRepository;
import org.sid.ecom.respositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EcomApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcomApplication.class, args);
    }

    @Bean //cette méthode sera exécuter au démarrage de l'application
    public CommandLineRunner start(ProductRepository productRepository, CategoryRepository categoryRepository){
        return args -> {
            Stream.of("Computer","Printers","Smart Phones").forEach(name->{
                Category category=new Category();
                category.setName(name);
                categoryRepository.save(category);

            });

            categoryRepository.findAll().forEach(cat -> {
                for(int i=1;i<=5;i++){
                    Product product = new Product();
                    product.setId(UUID.randomUUID().toString());
                    product.setName(cat.getName()+"-"+i);
                    product.setPrice(Math.random()*500);
                    product.setQuantity(Math.random()*100);
                    product.setCategory(cat);

                    productRepository.save(product);
                }
            });

        };

    }

}
