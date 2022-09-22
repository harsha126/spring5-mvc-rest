package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Bootstrap implements CommandLineRunner{
    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Category fruits = new Category();
        fruits.setName("fruits");
        Category dried = new Category();
        dried.setName("dried");
        Category fresh = new Category();
        fresh.setName("fresh");
        Category exotic = new Category();
        exotic.setName("exotic");
        Category nuts = new Category();
        nuts.setName("nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(nuts);
        categoryRepository.save(exotic);

        log.debug("Data Loaded Category");
        System.out.println("Data Loaded = "+categoryRepository.count());

        Customer customer1 =  new Customer();
        customer1.setFirstName("a");
        customer1.setLastName("b");
        Customer customer2 =  new Customer();
        customer2.setFirstName("c");
        customer2.setLastName("d");
        Customer customer3 =  new Customer();
        customer3.setFirstName("e");
        customer3.setLastName("f");
        Customer customer4 =  new Customer();
        customer4.setFirstName("g");
        customer4.setLastName("h");
        Customer customer5 =  new Customer();
        customer5.setFirstName("i");
        customer5.setLastName("j");
        Customer customer6 =  new Customer(22L,"gg","hh");
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);
        customerRepository.save(customer6);

        log.debug("Data Loaded Customers");
        System.out.println("Data Loaded = "+customerRepository.count());
    }
}
