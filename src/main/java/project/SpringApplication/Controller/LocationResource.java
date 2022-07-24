package project.SpringApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import project.SpringApplication.Entity.Country;
import project.SpringApplication.Entity.Location;
import project.SpringApplication.Service.LocationService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/locations")
public class LocationResource {
    @Autowired
    private LocationService locationService;

    @GET
    @Produces("application/json")
    public List<Location> getAll(){
        return locationService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Location getId(@PathParam("id") Long id){
        return locationService.findById(id);
    }
}
