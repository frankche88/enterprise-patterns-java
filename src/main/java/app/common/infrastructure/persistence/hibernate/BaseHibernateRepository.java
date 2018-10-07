package app.common.infrastructure.persistence.hibernate;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Named
public class BaseHibernateRepository<T> {

	protected SessionFactory sessionFactory;
	
	protected Class<T> typeParameterClass;

	@Inject
	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void persist(T entity) {
		getSession().persist(entity);
	}
	
	public void create(T entity) {
		getSession().save(entity);
	}
	
	public void update(T entity) {
		getSession().update(entity);
	}

	public void merge(T entity) {
		getSession().merge(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	public T read(Serializable id) {
		return getSession().get(typeParameterClass, id);
	}
	
	public void saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}
}
