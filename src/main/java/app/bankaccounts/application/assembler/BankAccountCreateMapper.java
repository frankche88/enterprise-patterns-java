package app.bankaccounts.application.assembler;

import org.modelmapper.PropertyMap;

import app.bankaccounts.application.dto.BankAccountCreateDto;
import app.bankaccounts.domain.entity.BankAccount;
import app.common.domain.valueObject.Money;
import app.customers.domain.entity.Customer;

public class BankAccountCreateMapper extends PropertyMap<BankAccountCreateDto, BankAccount> {

	@Override
	protected void configure() {
		
		Customer customer = new Customer();
		
		customer.setId(source.getCustomerId());
		
		map().setCustomer(customer);

		map().setBalance(new Money(source.getBalance(), source.getCurrency()));
		
	}

}
