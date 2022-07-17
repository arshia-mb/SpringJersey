package project.SpringApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.SpringApplication.Entity.Customer;
import project.SpringApplication.Exception.ResourceNotFoundException;
import project.SpringApplication.Repository.CustomerRepository;

import java.util.List;

@Service
public class CustomersService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Customer findByName(String name){
        return customerRepository.findByName(name);
    }

    public Customer findById(Long id){
        return customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer with id:"+id+" was not found!"));
    }

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }


    public void delete(Long id){
        Customer customer = findById(id);
        customerRepository.delete(customer);
    }

    public boolean existsById(Long id){
        return customerRepository.existsById(id);
    }
    public Long count(){
        return customerRepository.count();
    }
}
