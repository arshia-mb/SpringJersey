package project.SpringApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.SpringApplication.Controller.HelloResource;
import project.SpringApplication.Entity.Warehouse;
import project.SpringApplication.Service.WarehouseService;

@SpringBootApplication
@Configuration
public class Application {
	private static final Logger log = LoggerFactory.getLogger(HelloResource.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public CommandLineRunner initDatabase(WarehouseService warehouseService){
		return args -> {
			Warehouse warehouse = warehouseService.findById(1L);
			log.info("Showing Warehouse ->" + warehouse);
			log.info("Showing Warehouse.Locating ->" + warehouse.getLocation());
			log.info("Showing Warehouse Double" + warehouseService.findById(1L));
		};
	}
}
