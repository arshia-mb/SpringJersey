package project.SpringApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.SpringApplication.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}