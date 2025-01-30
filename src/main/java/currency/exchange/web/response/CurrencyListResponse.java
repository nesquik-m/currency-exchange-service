package currency.exchange.web.response;

import currency.exchange.dto.CurrencyItemDto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyListResponse {

    @Builder.Default
    private List<CurrencyItemDto> currencies = new ArrayList<>();

}