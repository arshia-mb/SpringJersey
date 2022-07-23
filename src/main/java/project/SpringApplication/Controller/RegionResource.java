package project.SpringApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import project.SpringApplication.Entity.Customer;
import project.SpringApplication.Entity.Region;
import project.SpringApplication.Service.RegionService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/regions")
public class RegionResource {
    @Autowired
    private RegionService regionService;

    @GET
    @Produces("application/json")
    public List<Region> getAll(){
        return regionService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Region getId(@PathParam("id") Long id){
        return regionService.findById(id);
    }

    @GET
    @Path("/byName={name}")
    @Produces("application/json")
    public List<Region> getName(@PathParam("name") String  name){
        return regionService.findByName(name);
    }
}
