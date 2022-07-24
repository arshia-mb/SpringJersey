package project.SpringApplication.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import project.SpringApplication.Entity.Location;
import project.SpringApplication.Entity.Warehouse;
import project.SpringApplication.Service.WarehouseService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainHello(){
        return "Hello Jersey";
    }

}
