package project.SpringApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.SpringApplication.Entity.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
}