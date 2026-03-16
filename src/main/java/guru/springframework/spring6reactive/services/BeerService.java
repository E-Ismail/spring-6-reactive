package guru.springframework.spring6reactive.services;

/*
 * @author Ech-Cherrate Ismail
 * @project spring-6-reactive
 * @create 16/03/2026 - 00:58
 */

import guru.springframework.spring6reactive.model.BeerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BeerService {

    Flux<BeerDTO> listBeers();

    Mono<BeerDTO> findBeerById(Integer beerId);

    Mono<BeerDTO> saveNewBeer(BeerDTO beerDTO);

    Mono<BeerDTO> updateBeer(Integer beerId, BeerDTO beerDTO);

    Mono<BeerDTO> patchBeer(Integer beerId, BeerDTO beerDTO);
}
