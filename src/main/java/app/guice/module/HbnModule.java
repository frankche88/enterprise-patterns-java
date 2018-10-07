package app.guice.module;

import org.hibernate.SessionFactory;

import com.google.inject.AbstractModule;

import app.bankAccounts.domain.repository.BankAccountRepository;
import app.bankAccounts.infrastructure.persistence.hibernate.BankAccountHibernateRepository;
import app.bundles.HbnBundle;
import app.customers.domain.repository.CustomerRepository;
import app.customers.infrastructure.persistence.hibernate.repository.CustomerHibernateRepository;
import app.movies.domain.repository.MovieRepository;
import app.movies.infrastructure.persistence.hibernate.MovieHibernateRepository;

public class HbnModule extends AbstractModule {

	private final HbnBundle hbnBundle;

    public HbnModule(HbnBundle hbnBundle) {
        this.hbnBundle = hbnBundle;
    }

    @Override
    protected void configure() {
        bind(SessionFactory.class).toInstance(hbnBundle.getSessionFactory());
        
        bind(MovieRepository.class).to(MovieHibernateRepository.class);
        
        bind(BankAccountRepository.class).to(BankAccountHibernateRepository.class);
        
        bind(CustomerRepository.class).to(CustomerHibernateRepository.class);
        
    }

}
