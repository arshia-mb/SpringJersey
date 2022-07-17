package project.SpringApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.SpringApplication.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}