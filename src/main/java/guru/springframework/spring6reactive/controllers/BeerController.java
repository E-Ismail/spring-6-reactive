package guru.springframework.spring6reactive.controllers;

/*
 * @author Ech-Cherrate Ismail
 * @project spring-6-reactive
 * @create 16/01/2026 - 00:09
 */

import guru.springframework.spring6reactive.model.BeerDTO;
import guru.springframework.spring6reactive.repositories.BeerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class BeerController {

    public static final String BEER_PATH = "/api/v2/beer";
    private final BeerRepository beerRepository;

    public BeerController(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @GetMapping(BEER_PATH)
    Flux<BeerDTO> listBeers() {
        return Flux.just(BeerDTO.builder().id(1).build(),
                BeerDTO.builder().id(2).build(),
                BeerDTO.builder().id(3).build());
    }
}
