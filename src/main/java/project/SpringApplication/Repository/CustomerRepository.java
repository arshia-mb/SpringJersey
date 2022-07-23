package project.SpringApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import project.SpringApplication.Entity.Customer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByName(String name);
    @Query("select c from Customer c where c.creditLimit between ?1 and ?2")
    List<Customer> findByCredit(BigDecimal creditLimitStart, BigDecimal creditLimitEnd);

}