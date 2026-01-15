package guru.springframework.spring6reactive.mapper;

/*
 * @author Ech-Cherrate Ismail
 * @project spring-6-reactive
 * @create 16/01/2026 - 00:20
 */

import guru.springframework.spring6reactive.domain.Beer;
import guru.springframework.spring6reactive.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    Beer  beerDTOToBeer(BeerDTO beerDTO);
    BeerDTO beerToBeerDTO(Beer beer);
}
