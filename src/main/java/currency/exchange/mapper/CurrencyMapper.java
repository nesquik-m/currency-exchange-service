package currency.exchange.mapper;

import currency.exchange.dto.CurrencyItemDto;
import currency.exchange.dto.CurrencyList;
import org.mapstruct.Mapper;
import currency.exchange.dto.CurrencyDto;
import currency.exchange.entity.Currency;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {

    CurrencyDto convertToDto(Currency currency);

    Currency convertToEntity(CurrencyDto currencyDto);

    CurrencyItemDto convertToItemDto(Currency currency);

    default CurrencyList convertToDtoList(List<Currency> currencies) {
        if (currencies == null || currencies.isEmpty()) {
            return new CurrencyList();
        }

        List<CurrencyItemDto> currencyItemDtos = currencies.stream()
                .map(this::convertToItemDto)
                .collect(Collectors.toList());

        return new CurrencyList(currencyItemDtos);
    }

}