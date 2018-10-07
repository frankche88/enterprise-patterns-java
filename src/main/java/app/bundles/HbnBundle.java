package app.bundles;

import java.io.InputStream;

import com.google.common.collect.ImmutableList;

import app.AppConfiguration;
import app.bankAccounts.infrastructure.persistence.hibernate.BankAccountHibernateRepository;
import app.customers.infrastructure.persistence.hibernate.repository.CustomerHibernateRepository;
import app.movies.infrastructure.persistence.hibernate.MovieHibernateRepository;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.SessionFactoryFactory;

public class HbnBundle extends HibernateBundle<AppConfiguration> {

	
	public HbnBundle() {
		super(ImmutableList.of(), new SessionFactoryFactory());
	}

	@Override
	public PooledDataSourceFactory getDataSourceFactory(AppConfiguration configuration) {
		return configuration.getDataSourceFactory();

	}
	
	protected void configure(org.hibernate.cfg.Configuration configuration) {
		

		
		InputStream inputMovie = MovieHibernateRepository.class.getClassLoader().getResourceAsStream("hibernate/movie.hbm.xml");
		
		InputStream inputDirector = MovieHibernateRepository.class.getClassLoader().getResourceAsStream("hibernate/director.hbm.xml");
		
		InputStream inputCustomer = CustomerHibernateRepository.class.getClassLoader().getResourceAsStream("hibernate/customer.hbm.xml");
		
		InputStream inputBankAccount = BankAccountHibernateRepository.class.getClassLoader().getResourceAsStream("hibernate/bankAccount.hbm.xml");
		
		configuration.addInputStream(inputMovie);
		configuration.addInputStream(inputDirector);
		configuration.addInputStream(inputCustomer);
		configuration.addInputStream(inputBankAccount);
		
    }

}
