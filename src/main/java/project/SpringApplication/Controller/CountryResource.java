package project.SpringApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import project.SpringApplication.Entity.Country;
import project.SpringApplication.Service.CountryService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/country")
public class CountryResource {
    @Autowired
    private CountryService countryService;

    @GET
    @Produces("application/json")
    public List<Country> getAll(){
        return countryService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Country getId(@PathParam("id") String id){
        return countryService.findById(id);
    }


}
