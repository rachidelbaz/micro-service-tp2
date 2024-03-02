package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.sid.inventoryservice.repositories.ProductRepository;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Product.class);
        return args -> {
            productRepository.saveAll(
                    List.of(
                            Product.builder().name("laptop").quantity(343).price(2333).build(),
                            Product.builder().name("camera").quantity(209).price(265).build(),
                            Product.builder().name("telephone").quantity(621).price(809).build()

                    )
            );
        };

    }
}
