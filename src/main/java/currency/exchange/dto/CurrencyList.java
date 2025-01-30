package currency.exchange.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyList {

    @Builder.Default
    private List<CurrencyItemDto> currencies = new ArrayList<>();

}