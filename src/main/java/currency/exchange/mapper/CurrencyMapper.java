package currency.exchange.mapper;

import currency.exchange.dto.*;
import currency.exchange.web.response.CurrencyListResponse;
import currency.exchange.web.response.CurrencyResponse;
import org.mapstruct.Mapper;
import currency.exchange.entity.Currency;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {

    CurrencyResponse convertToDto(Currency currency);

    Currency convertToEntity(CurrencyResponse currencyResponse);

    Currency convertToEntity(XmlCurrency currencyDto);

    CurrencyItemDto convertToItemDto(Currency currency);

    default CurrencyListResponse convertToDtoList(List<Currency> currencies) {
        if (currencies == null || currencies.isEmpty()) {
            return new CurrencyListResponse();
        }

        List<CurrencyItemDto> currencyItemDtos = currencies.stream()
                .map(this::convertToItemDto)
                .collect(Collectors.toList());

        return new CurrencyListResponse(currencyItemDtos);
    }

    default List<Currency> convertToEntityList(List<XmlCurrency> currencies) {
        return currencies.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }

}