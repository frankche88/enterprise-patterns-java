package app.customers.infrastructure.persistence.hibernate.repository;

import app.common.infrastructure.persistence.hibernate.BaseHibernateRepository;
import app.customers.domain.entity.Customer;
import app.customers.domain.repository.CustomerRepository;

public class CustomerHibernateRepository extends BaseHibernateRepository<Customer> implements CustomerRepository {

}
