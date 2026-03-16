package guru.springframework.spring6reactive.mapper;

/*
 * @author Ech-Cherrate Ismail
 * @project spring-6-reactive
 * @create 16/03/2026 - 17:54
 */

import guru.springframework.spring6reactive.domain.Customer;
import guru.springframework.spring6reactive.model.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper
public interface CustomerMapper {

    @Mapping(target = "createdDate", expression = "java(customerDTO.getCreatedDate()!=null?customerDTO.getCreatedDate():java.time.LocalDateTime.now())")
    @Mapping(target = "lastModifiedDate", expression = "java(resolveDate(customerDTO.getLastModifiedDate()))")
    Customer customerDTOtoCustomer(CustomerDTO customerDTO);

    CustomerDTO customerToCustomerDTO(Customer customer);


    default LocalDateTime resolveDate(LocalDateTime date) {
        return date != null ? date : LocalDateTime.now();
    }

}
