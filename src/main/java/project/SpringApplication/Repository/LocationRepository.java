package project.SpringApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.SpringApplication.Entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}