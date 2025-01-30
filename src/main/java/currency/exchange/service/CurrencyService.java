package currency.exchange.service;

import currency.exchange.exception.EntityNotFoundException;
import currency.exchange.web.response.CurrencyListResponse;
import currency.exchange.web.response.CurrencyResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import currency.exchange.entity.Currency;
import currency.exchange.mapper.CurrencyMapper;
import currency.exchange.repository.CurrencyRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRepository repository;

    private final CurrencyMapper mapper;

    public CurrencyResponse getById(Long id) {
        log.info("CurrencyService method getById executed");
        Currency currency = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Currency not found with id: " + id));
        return mapper.convertToDto(currency);
    }

    public Double convertValue(Long value, Long numCode) {
        log.info("CurrencyService method convertValue executed");
        return repository.findByIsoNumCode(numCode)
                .map(currency -> value * currency.getValue())
                .orElseThrow(() -> new EntityNotFoundException("Currency not found with numCode: " + numCode));
    }

    public CurrencyResponse create(CurrencyResponse dto) {
        log.info("CurrencyService method create executed");
        return mapper.convertToDto(repository.save(mapper.convertToEntity(dto)));
    }

    public CurrencyListResponse getAll() {
        log.info("CurrencyService method getAll executed");
        return mapper.convertToDtoList(repository.findAll());
    }

    public void updateCurrencies(List<Currency> currencies) {
        log.info("CurrencyService method updateCurrencies executed");
        currencies.forEach(currency ->
                repository.findByIsoCharCode(currency.getIsoCharCode())
                        .ifPresentOrElse(
                                existingCurrency -> {
                                    existingCurrency.setValue(currency.getValue());
                                    repository.save(existingCurrency);
                                },
                                () -> repository.save(currency)
                        )
        );
    }

}