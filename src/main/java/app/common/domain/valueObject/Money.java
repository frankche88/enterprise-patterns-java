package app.common.domain.valueObject;

import java.math.BigDecimal;

import app.common.application.enumeration.Currency;

public class Money {

	protected void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	protected void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public BigDecimal amount;
	public Currency currency;

	public Money() {
	}

	public Money(BigDecimal amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public static Money dollars(BigDecimal amount) {
		return new Money(amount, Currency.USD);
	}

	public static Money soles(BigDecimal amount) {
		return new Money(amount, Currency.PEN);
	}

	public static Money euros(BigDecimal amount) {
		return new Money(amount, Currency.EUR);
	}

}
