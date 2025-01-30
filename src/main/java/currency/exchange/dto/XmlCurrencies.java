package currency.exchange.dto;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "ValCurs")
@ToString
@Getter
public class XmlCurrencies {

    @XmlAttribute(name = "Date")
    public String date;

    @XmlAttribute(name = "name")
    public String name;

    @XmlElement(name = "Valute")
    public List<XmlCurrency> xmlCurrencyList;

}