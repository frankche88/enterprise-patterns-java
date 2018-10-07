package app.bankAccounts.domain.repository;

import app.bankaccounts.domain.entity.BankAccount;

public interface BankAccountRepository {

	void create(BankAccount bankAccount);

	void delete(BankAccount bankAccount);

	BankAccount read(long id);

}
