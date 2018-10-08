package app.common.application.enumeration;

import javax.persistence.AttributeConverter;

public class CurrencyConverter implements AttributeConverter<Currency, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Currency value) {
		if ( value == null ) {
            return null;
        }

        return value.getCurrencyCode();
	}

	@Override
	public Currency convertToEntityAttribute(Integer value) {
		if ( value == null ) {
            return null;
        }

        return Currency.fromCode(value);
	}

}
