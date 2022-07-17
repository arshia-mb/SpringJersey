package project.SpringApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.SpringApplication.Entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}