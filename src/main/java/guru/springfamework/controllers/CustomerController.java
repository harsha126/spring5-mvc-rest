package guru.springfamework.controllers;

import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.api.v1.model.CustomerListDTO;
import guru.springfamework.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/customers/")
public class CustomerController {
    private  final CustomerMapper customerMapper;
    private final CustomerService customerService;

    public CustomerController(CustomerMapper customerMapper, CustomerService customerService) {
        this.customerMapper = customerMapper;
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<CustomerListDTO> getAllCustomer(){
        return new ResponseEntity<CustomerListDTO>(new CustomerListDTO(customerService.getAllCustomers()), HttpStatus.OK);
    }
    @GetMapping("{name}")
    public ResponseEntity<CustomerDTO> getCustomerByLastName(@PathVariable String name){
        try{
            Long al = Long.parseLong(name);
            return new ResponseEntity<CustomerDTO>(customerService.getCustomerByID(al),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<CustomerDTO>(customerService.getCustomerByLastName(name),HttpStatus.OK);
        }
    }
//    @GetMapping("{ID}")
//    public ResponseEntity<CustomerDTO> getCustomerByID(@PathVariable String ID){
//        return new ResponseEntity<CustomerDTO>(customerService.getCustomerByID(new Long(ID)),HttpStatus.OK);
//    }

}
