package project.SpringApplication.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import project.SpringApplication.DTO.WarehouseDTO;
import project.SpringApplication.Entity.Warehouse;
import project.SpringApplication.Service.LocationService;
import project.SpringApplication.Service.WarehouseService;

import javax.ws.rs.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/warehouse")
public class WarehouseResource {
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private ModelMapper modelMapper;

    @GET
    @Produces("application/json")
    public List<WarehouseDTO> getAll(){
        return warehouseService.findAll().stream().map(this::convertDTO).collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Warehouse getId(@PathParam("id") Long id){
        return warehouseService.findById(id);
    }

    @GET
    @Path("/id")
    @Produces("application/json")
    public List<Warehouse> getOnes(@PathParam("id") Long id, @DefaultValue("1")@QueryParam("list")String val){
        String[] words = val.split("n");
        ArrayList<Long> ids = new ArrayList<>();
        for(String st:words){
            ids.add(Long.parseLong(st));
        }
        return warehouseService.findByIdIn(ids);
    }


    private WarehouseDTO convertDTO(Warehouse warehouse){
        WarehouseDTO warehouseDTO = modelMapper.map(warehouse,WarehouseDTO.class);
        return warehouseDTO;
    }

    private Warehouse convertToEntity(WarehouseDTO warehouseDTO){
        Warehouse warehouse = modelMapper.map(warehouseDTO,Warehouse.class);
        if (warehouseDTO.getId() != null) {
            Warehouse oldPost = warehouseService.findById(warehouseDTO.getId());
        }
        return warehouse;
    }

}
