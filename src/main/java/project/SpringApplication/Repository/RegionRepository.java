package project.SpringApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.SpringApplication.Entity.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}