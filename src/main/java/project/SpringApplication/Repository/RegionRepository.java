package project.SpringApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.SpringApplication.Entity.Region;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {
    List<Region> findByRegionNameIgnoreCase(String regionName);
}