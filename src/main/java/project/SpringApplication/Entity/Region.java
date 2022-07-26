package project.SpringApplication.Entity;

import javax.persistence.*;

@Entity
@Table(name = "REGIONS")
@Cacheable
public class Region {
    @Id
    @Column(name = "REGION_ID", nullable = false)
    private Long id;

    @Column(name = "REGION_NAME", nullable = false, length = 50)
    private String regionName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

}