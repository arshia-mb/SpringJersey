package project.SpringApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.SpringApplication.Entity.Customer;
import project.SpringApplication.Service.CustomersService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/spring/customers")
public class CustomerController {
    @Autowired
    private CustomersService customersService;

    @GetMapping
    public ResponseEntity<?> all(@RequestParam (name = "name",defaultValue = "non")String name){
        List<Customer> customers = new ArrayList<>();
        if(name.equals("non"))
            return new  ResponseEntity<>(customersService.findAll(), HttpStatus.OK);
        return new  ResponseEntity<>(customersService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable (name = "id")Long id,@RequestParam(name = "type",defaultValue = "default") String type){
        Customer customer = customersService.findById(id);
        if(type.equals("name"))
            return new ResponseEntity<>(customer.getName(),HttpStatus.OK);
        if(type.equals("address"))
            return new ResponseEntity<>(customer.getAddress(),HttpStatus.OK);
        if(type.equals("website"))
            return new ResponseEntity<>(customer.getWebsite(),HttpStatus.OK);
        if(type.equals("credit"))
            return new ResponseEntity<>(customer.getCreditLimit(),HttpStatus.OK);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

}



