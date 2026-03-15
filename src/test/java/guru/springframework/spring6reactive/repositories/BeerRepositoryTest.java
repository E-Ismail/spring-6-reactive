package guru.springframework.spring6reactive.repositories;

import guru.springframework.spring6reactive.config.DatabaseConfig;
import guru.springframework.spring6reactive.domain.Beer;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import java.math.BigDecimal;
import java.util.Arrays;

//Test Splice for R2DBC
@DataR2dbcTest
@Import(DatabaseConfig.class)
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    @Disabled("Application Context for splice test")
    void databaseConfigBean(){
        String[] beans =  applicationContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        Arrays.stream(beans).forEach(System.out::println);
    }

    @Test
    void saveNewBeer() {
        beerRepository.save(getTestBeer())
                .subscribe(beer -> System.out.println(beer.toString()));
    }

    Beer getTestBeer() {
        return Beer.builder()
                .beerName("Space Dust")
                .beerStyle("IPA")
                .price(BigDecimal.TEN)
                .quantityOnHand(12)
                .upc("123213")
                .build();
    }
}
