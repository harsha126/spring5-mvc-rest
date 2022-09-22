package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
//        return customerRepository.findAll().stream().map(customerMapper::CustomerToCustomerDTO).collect(Collectors.toList());
        return customerRepository.findAll().stream().map(customer -> {
            CustomerDTO customerDTO = customerMapper.CustomerToCustomerDTO(customer);
            customerDTO.setCustomerUrl("/api/v1/customers/"+customer.getId());
            return customerDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerByLastName(String name) {

        return customerMapper.CustomerToCustomerDTO(customerRepository.findByLastName(name));
    }

    @Override
    public CustomerDTO getCustomerByID(Long ID) {
        return customerMapper.CustomerToCustomerDTO(customerRepository.findById(ID).get());
    }
}
