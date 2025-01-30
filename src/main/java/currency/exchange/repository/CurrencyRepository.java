package currency.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import currency.exchange.entity.Currency;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Optional<Currency> findByIsoNumCode(Long isoNumCode);

    Optional<Currency> findByIsoCharCode(String isoCharCode);

}