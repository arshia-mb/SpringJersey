package project.SpringApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.SpringApplication.Entity.Location;
import project.SpringApplication.Entity.Warehouse;
import project.SpringApplication.Repository.WarehouseRepository;

import java.util.List;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository;

    public List<Warehouse> findAll(){return warehouseRepository.findAll();}
    public Warehouse findById(Long id){
        return warehouseRepository.findById(id).orElseThrow(()->new RuntimeException("Resource not found!"));
    }

    public List<Warehouse> findByLocationId(Long id){
        return warehouseRepository.findByLocationId(id);
    }
}
