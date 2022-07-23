package project.SpringApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.SpringApplication.Entity.Region;
import project.SpringApplication.Repository.RegionRepository;

import java.util.List;

@Service
public class RegionService {
    @Autowired
    private RegionRepository repository;

    public List<Region> findAll(){
        return repository.findAll();
    }

    public Region findById(Long id){
        return repository.findById(id).orElseThrow(()->new RuntimeException("Resource not found!"));
    }

    public List<Region> findByName(String name){
        return repository.findByRegionNameIgnoreCase(name);
    }

    public boolean exists(Long id){
        return repository.existsById(id);
    }
}
