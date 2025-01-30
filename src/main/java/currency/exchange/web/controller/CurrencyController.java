package currency.exchange.web.controller;

import currency.exchange.web.response.CurrencyResponse;
import currency.exchange.web.response.CurrencyListResponse;
import currency.exchange.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping(value = "/{id}")
    public CurrencyResponse getById(@PathVariable("id") Long id) {
        return currencyService.getById(id);
    }

    @GetMapping(value = "/convert")
    public Double convertValue(@RequestParam("value") Long value,
                               @RequestParam("numCode") Long numCode) {
        return currencyService.convertValue(value, numCode);
    }

    @PostMapping("/create")
    public CurrencyResponse create(@RequestBody CurrencyResponse dto) {
        return currencyService.create(dto);
    }

    @GetMapping("/currency")
    public CurrencyListResponse getAll() {
        return currencyService.getAll();
    }

}