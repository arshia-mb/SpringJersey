package project.SpringApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import project.SpringApplication.Entity.Location;
import project.SpringApplication.Entity.Warehouse;
import project.SpringApplication.Service.WarehouseService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/warehouse")
public class WarehouseResource {
    @Autowired
    private WarehouseService warehouseService;

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

}
