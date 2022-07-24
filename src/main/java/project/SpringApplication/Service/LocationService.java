package project.SpringApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.SpringApplication.Entity.Country;
import project.SpringApplication.Entity.Location;
import project.SpringApplication.Repository.LocationRepository;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public List<Location> findAll(){return locationRepository.findAll();}
    public Location findById(Long id){
        return locationRepository.findById(id).orElseThrow(()->new RuntimeException("Resource not found!"));
    }

    public List<Location> findByCountryId(String id){
        return locationRepository.findByCountryId(id);
    }
}
