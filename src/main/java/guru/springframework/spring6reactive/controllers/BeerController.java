package guru.springframework.spring6reactive.controllers;

/*
 * @author Ech-Cherrate Ismail
 * @project spring-6-reactive
 * @create 16/01/2026 - 00:09
 */

import guru.springframework.spring6reactive.model.BeerDTO;
import guru.springframework.spring6reactive.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class BeerController {

    public static final String BEER_PATH = "/api/v2/beer";
    public static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";
    private final BeerService beerService;

    @GetMapping(BEER_PATH)
    Flux<BeerDTO> listBeers() {
        return beerService.listBeers();
    }

    @GetMapping(BEER_PATH_ID)
    Mono<BeerDTO> findBeerById(@PathVariable Integer beerId) {
        return beerService.findBeerById(beerId);
    }

    @PostMapping(BEER_PATH)
    Mono<ResponseEntity<Void>> createNewBeer(@Validated @RequestBody BeerDTO beerDTO) {
        return beerService.saveNewBeer(beerDTO)
                .map(savedDto -> ResponseEntity
                        .created
                                (
                                        UriComponentsBuilder
                                                .fromUriString("localhost:8080/" + BEER_PATH + "/" + savedDto.getId())
                                                .build().toUri()
                                )
                        .build()
                );
    }

    @PutMapping(BEER_PATH_ID)
    Mono<ResponseEntity<BeerDTO>> updateBeer(@PathVariable("beerId") Integer beerId, @Validated @RequestBody BeerDTO beerDTO) {
        return beerService.updateBeer(beerId, beerDTO)
                .map(updatedBeer -> ResponseEntity.ok().body(updatedBeer));
    }

    @PatchMapping(BEER_PATH_ID)
    Mono<ResponseEntity<Void>> patchBeer(@PathVariable("beerId") Integer beerId, @Validated @RequestBody BeerDTO beerDTO) {
        return beerService.patchBeer(beerId, beerDTO)
                .map(updatedBeer -> ResponseEntity.accepted().build());
    }

    @DeleteMapping(BEER_PATH_ID)
    Mono<ResponseEntity<Void>> deleteBeer(@PathVariable("beerId") Integer beerId) {
        return beerService.deleteBeerById(beerId).then(Mono.fromCallable(() -> ResponseEntity.noContent().build()));
    }
}
