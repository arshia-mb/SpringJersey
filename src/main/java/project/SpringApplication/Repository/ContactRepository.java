package project.SpringApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.SpringApplication.Entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}