package project.SpringApplication.Repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import project.SpringApplication.Entity.Country;
import project.SpringApplication.Entity.Warehouse;

import java.util.List;
import java.util.Optional;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    //@EntityGraph(attributePaths = {"location.country.region"})
    List<Warehouse> findAll();

    //@EntityGraph(attributePaths = {"location.country.region"})
    Optional<Warehouse> findById(Long id);
    //@EntityGraph(attributePaths = {"location.country.region"})
    List<Warehouse> findByLocationId(Long regionId);
}