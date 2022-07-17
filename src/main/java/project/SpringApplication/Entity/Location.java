package project.SpringApplication.Entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "LOCATIONS")
public class Location {
    @Id
    @Column(name = "LOCATION_ID", nullable = false)
    private Long id;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "POSTAL_CODE", length = 20)
    private String postalCode;

    @Column(name = "CITY", length = 50)
    private String city;

    @Column(name = "STATE", length = 50)
    private String state;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}