package org.sid.microservicetp2;

import org.sid.microservicetp2.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.sid.microservicetp2.repositories.CustomerRepository;

import java.util.List;

@SpringBootApplication
public class MicroServiceTp2Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceTp2Application.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Customer.class);
            customerRepository.saveAll(
                    List.of(
                            Customer.builder().name("rachid").email("rachid@gmail.com").build(),
                            Customer.builder().name("hicham").email("email@gmail.com").build(),
                            Customer.builder().name("fatima").email("fatima@gmail.com").build()
                    )
            );
            customerRepository.findAll().forEach(c->{
                System.out.println(c);
            });
        };
    }
}
