package guru.springframework.spring6reactive.model;

/*
 * @author Ech-Cherrate Ismail
 * @project spring-6-reactive
 * @create 16/01/2026 - 00:11
 */

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO {


    private Integer id;

    @NotBlank
    @Length(min = 3, max = 255)
    private String beerName;
    @Length(min = 1, max = 255)
    private String beerStyle;

    @Size(max = 25)
    private String upc;

    @PositiveOrZero
    private Integer quantityOnHand;

    private BigDecimal price;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

}
