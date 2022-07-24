package project.SpringApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import project.SpringApplication.Entity.Warehouse;
import project.SpringApplication.Service.LocationService;
import project.SpringApplication.Service.WarehouseService;

import javax.ws.rs.*;
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
    public ResponseEntity<?> getId(@PathParam("id") Long id, @DefaultValue("")@QueryParam("val")String val){
        Warehouse warehouse = warehouseService.findById(id);
        if (val.equals(""))
            return new ResponseEntity<>(locationService.findById((warehouse.getLocation().getId())), HttpStatus.OK);
        return new ResponseEntity<>(warehouse,HttpStatus.OK);
    }

}
