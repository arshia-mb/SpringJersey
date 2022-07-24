package project.SpringApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import project.SpringApplication.Entity.Warehouse;
import project.SpringApplication.Service.LocationService;
import project.SpringApplication.Service.WarehouseService;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("/warehouse")
public class WarehouseResource {
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private LocationService locationService;

    @GET
    @Produces("application/json")
    public List<Warehouse> getAll(){
        return warehouseService.findAll();
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



}
