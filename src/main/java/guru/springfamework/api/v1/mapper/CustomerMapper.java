package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    @Mapping(source = "id",target = "id")
    @Mapping(source = "firstName",target = "firstName")
    @Mapping(source = "lastName",target = "lastName")
    CustomerDTO CustomerToCustomerDTO(Customer customer);

}
