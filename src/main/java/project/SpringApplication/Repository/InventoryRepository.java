package project.SpringApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.SpringApplication.Entity.Inventory;
import project.SpringApplication.Entity.InventoryId;

public interface InventoryRepository extends JpaRepository<Inventory, InventoryId> {
}