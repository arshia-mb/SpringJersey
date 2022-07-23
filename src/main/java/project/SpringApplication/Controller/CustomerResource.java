package project.SpringApplication.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import project.SpringApplication.Entity.Customer;
import project.SpringApplication.Service.CustomersService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Path("/jrs/customers")
public class CustomerResource {
    @Autowired
    private CustomersService customersService;

    private static final Logger log = LoggerFactory.getLogger(CustomerResource.class);

    @GET
    @Produces("application/json")
    public List<Customer> getAllCustomers(){
        //long startTime = System.nanoTime();
        List<Customer> customers = customersService.findAll();
        //log.info("Time for executing findAll service nano seconds: " + endTime);
        return customersService.findAll();
    }

    //Jersey method that looks like Spring RestController
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public ResponseEntity<?> getCustomerById(@PathParam("id")Long id, @DefaultValue("default")@QueryParam("type")String type) throws URISyntaxException {
        Customer customer = customersService.findById(id);
        return switch (type) {
            case "name" -> new ResponseEntity<>(customer.getName(), HttpStatus.OK);
            case "address" -> new ResponseEntity<>(customer.getAddress(), HttpStatus.OK);
            case "website" -> new ResponseEntity<>(customer.getWebsite(), HttpStatus.OK);
            case "creditLimit" -> new ResponseEntity<>(customer.getCreditLimit(), HttpStatus.OK);
            default -> new ResponseEntity<>(customer, HttpStatus.OK);
        };
    }

    //Basic Jersey method
    @GET
    @Path("/name/{name}")
    @Produces("application/json")
    public Response getCustomerByName(@PathParam("name")String name) throws URISyntaxException {
        Customer customer = customersService.findByName(name);
        if(customer == null){
            return Response.status(404).build();
        }
        return Response
                .status(200)
                .entity(customer).build();
    }

    @GET
    @Path("/credit/between{c1}AND{c2}")
    @Produces("application/json")
    public Response getCustomerByCredit(@PathParam("c1") BigDecimal c1,@PathParam("c2")BigDecimal c2) throws URISyntaxException {
        List<Customer> customer = customersService.findByCreditBetween(c1,c2);
        if(customer == null){
            return Response.status(404).build();
        }
        return Response
                .status(200)
                .entity(customer).build();
    }

    @POST
    @Consumes("application/json")
    public Response createCustomer(Customer customer){
        if (customer.getName() == null)
            return Response.status(400).entity("Provide all mandatory inputs").build();
        customer.setId(customersService.count()+1);
        Customer _return = customersService.save(customer);
        return Response.status(201).entity(_return).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id")Long id){
        customersService.delete(id);
        return Response.status(200).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces(MediaType.TEXT_PLAIN)
    public String updateCustomer(@PathParam("id")Long id,Customer _customer){
        Customer customer = customersService.findById(id);
        if(_customer.getName()!=null)
            customer.setName(_customer.getName());
        if(_customer.getAddress()!=null)
            customer.setAddress(_customer.getAddress());
        if(_customer.getWebsite()!=null)
            customer.setWebsite(_customer.getWebsite());
        if(_customer.getCreditLimit()!=null)
            customer.setCreditLimit(_customer.getCreditLimit());
        customersService.save(customer);
        return customer.toString();
    }
}
