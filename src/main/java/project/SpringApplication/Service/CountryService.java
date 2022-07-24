package project.SpringApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.SpringApplication.Entity.Country;
import project.SpringApplication.Repository.CountryRepository;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> findAll(){return countryRepository.findAll();}
    public Country findById(String id){
        return countryRepository.findById(id).orElseThrow(()->new RuntimeException("Resource not found!"));
    }

    public boolean existsById(String id){return countryRepository.existsById(id);}

    public List<Country> findByRegionId(Long regionId){
        return countryRepository.findByRegionId(regionId);
    }
}
