package app.bankAccounts.infrastructure.persistence.hibernate;

import app.bankAccounts.domain.repository.BankAccountRepository;
import app.bankaccounts.domain.entity.BankAccount;
import app.common.infrastructure.persistence.hibernate.BaseHibernateRepository;

public class BankAccountHibernateRepository extends BaseHibernateRepository<BankAccount> implements BankAccountRepository {
	
	public BankAccountHibernateRepository() {
		
		typeParameterClass = BankAccount.class;
		
	}

	@Override
	public BankAccount read(long id) {
		return super.read(id);
	}

}
