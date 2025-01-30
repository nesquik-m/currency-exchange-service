package currency.exchange.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class DoubleAdapter extends XmlAdapter<String, Double> {

    @Override
    public Double unmarshal(String value) {
        if (value == null) {
            return null;
        }
        try {
            NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
            Number number = format.parse(value);
            return number.doubleValue();
        } catch (ParseException e) {
            return null;
        }
    }

    @Override
    public String marshal(Double v) {
        if (v == null) {
            return null;
        }
        return v.toString();
    }

}
