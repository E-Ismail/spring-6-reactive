package guru.springframework.spring6reactive.mapper;

/*
 * @author Ech-Cherrate Ismail
 * @project spring-6-reactive
 * @create 16/01/2026 - 00:20
 */

import guru.springframework.spring6reactive.domain.Beer;
import guru.springframework.spring6reactive.model.BeerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper
public interface BeerMapper {


    @Mapping(target = "createdDate", expression = "java(beerDTO.getCreatedDate()!=null?beerDTO.getCreatedDate():java.time.LocalDateTime.now())")
    @Mapping(target = "lastModifiedDate", expression = "java(resolveDate(beerDTO.getLastModifiedDate()))")
    Beer beerDTOToBeer(BeerDTO beerDTO);

    BeerDTO beerToBeerDTO(Beer beer);

    default LocalDateTime resolveDate(LocalDateTime date) {
        return date != null ? date : LocalDateTime.now();
    }
}
