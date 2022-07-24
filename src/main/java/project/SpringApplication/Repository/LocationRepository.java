package project.SpringApplication.Repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import project.SpringApplication.Entity.Location;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {
    @EntityGraph(attributePaths = {"country","country.region"})
    List<Location> findAll();

    @EntityGraph(attributePaths = {"country","country.region"})
    Optional<Location> findById(Long id);
    @EntityGraph(attributePaths = {"country","country.region"})
    List<Location> findByCountryId(String countryId);
}