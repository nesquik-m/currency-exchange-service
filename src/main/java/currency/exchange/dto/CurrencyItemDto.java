package currency.exchange.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyItemDto {

    private String name;

    private Double value;

}
