package currency.exchange.controller;

import currency.exchange.dto.CurrencyDto;
import currency.exchange.dto.CurrencyList;
import currency.exchange.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/currency")
public class CurrencyController {

    private final CurrencyService service;

    @GetMapping(value = "/{id}")
    public CurrencyDto getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @GetMapping(value = "/convert")
    public Double convertValue(@RequestParam("value") Long value,
                               @RequestParam("numCode") Long numCode) {
        return service.convertValue(value, numCode);
    }

    @PostMapping("/create")
    public CurrencyDto create(@RequestBody CurrencyDto dto) {
        return service.create(dto);
    }

    @GetMapping("/currency")
    public CurrencyList getAll() {
        return service.getAll();
    }

}