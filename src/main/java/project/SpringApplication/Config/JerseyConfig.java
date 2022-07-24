package project.SpringApplication.Config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import project.SpringApplication.Controller.*;
import project.SpringApplication.Entity.Location;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(HelloResource.class);
        register(CustomerResource.class);
        register(RegionResource.class);
        register(CountryResource.class);
        register(LocationResource.class);
        register(WarehouseResource.class);
    }
}
