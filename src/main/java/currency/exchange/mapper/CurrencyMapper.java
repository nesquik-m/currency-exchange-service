package currency.exchange.mapper;

import org.mapstruct.Mapper;
import currency.exchange.dto.CurrencyDto;
import currency.exchange.entity.Currency;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {

    CurrencyDto convertToDto(Currency currency);

    Currency convertToEntity(CurrencyDto currencyDto);

}
