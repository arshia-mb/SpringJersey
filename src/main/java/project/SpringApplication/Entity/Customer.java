package project.SpringApplication.Entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {
    @Id
    @Column(name = "CUSTOMER_ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "WEBSITE")
    private String website;

    @Column(name = "CREDIT_LIMIT", precision = 8, scale = 2)
    private BigDecimal creditLimit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", website='" + website + '\'' +
                ", creditLimit=" + creditLimit +
                '}';
    }
}