package project.SpringApplication.Repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import project.SpringApplication.Entity.Country;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, String> {
    @EntityGraph(attributePaths = {"region"})
    List<Country> findAll();

    @EntityGraph(attributePaths = {"region"})
    Optional<Country> findById(String id);
    @EntityGraph(attributePaths = {"region"})
    List<Country> findByRegionId(Long regionId);

}