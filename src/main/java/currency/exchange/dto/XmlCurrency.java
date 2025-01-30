package currency.exchange.dto;

import currency.exchange.adapter.DoubleAdapter;
import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@ToString
@Getter
public class XmlCurrency {

    @XmlElement(name = "Name")
    public String name;

    @XmlElement(name = "Value")
    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double value;

    @XmlElement(name = "Nominal")
    public Long nominal;

    @XmlElement(name = "NumCode")
    public Long isoNumCode;

    @XmlElement(name = "CharCode")
    public String isoCharCode;

}