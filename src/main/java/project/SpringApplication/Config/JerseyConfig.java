package project.SpringApplication.Config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import project.SpringApplication.Controller.CustomerResource;
import project.SpringApplication.Controller.HelloResource;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(HelloResource.class);
        register(CustomerResource.class);
    }
}
