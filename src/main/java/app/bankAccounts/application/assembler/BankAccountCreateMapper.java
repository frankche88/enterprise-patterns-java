package app.bankAccounts.application.assembler;

import org.modelmapper.PropertyMap;

import app.bankAccounts.application.dto.BankAccountCreateDto;
import app.bankAccounts.domain.entity.BankAccount;
import app.common.domain.valueObject.Money;
import app.customers.domain.entity.Customer;

public class BankAccountCreateMapper extends PropertyMap<BankAccountCreateDto, BankAccount> {

	@Override
	protected void configure() {
		map().setBalance(new Money(source.getBalance(), source.getCurrency()));
		
		Customer customer = new Customer();
		
		customer.setId(source.getCustomerId());
		
		map().setCustomer(customer);
		
	}

}
