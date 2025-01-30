package currency.exchange.service;

import currency.exchange.dto.XmlCurrencies;
import currency.exchange.mapper.CurrencyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.*;

@Slf4j
@Service
@RequiredArgsConstructor
@EnableScheduling
public class OpenSourceService {

    private final RestTemplate restTemplate;

    private final CurrencyService currencyService;

    private final CurrencyMapper currencyMapper;

    @Value("${app.source-url}")
    private String sourceUrl;

    @Scheduled(cron = "${app.cron}")
    public void getCurrencyData() {
        try {
            log.info("Getting currency data...");
            XmlCurrencies xmlCurrencies = parseXml();
            currencyService.updateCurrencies(currencyMapper.convertToEntityList(xmlCurrencies.getXmlCurrencyList()));
        } catch (Exception e) {
            log.error("Error getting currency data", e);
        }
    }

    public XmlCurrencies parseXml() throws JAXBException {
        String xmlData = restTemplate.getForObject(sourceUrl, String.class);
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlCurrencies.class);
        return (XmlCurrencies) jaxbContext.createUnmarshaller()
                .unmarshal(new StringReader(xmlData));
    }

}