package app.movies.infrastructure.persistence.hibernate;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import app.common.domain.specification.Specification;
import app.common.infrastructure.persistence.hibernate.BaseHibernateRepository;
import app.movies.domain.entity.Movie;
import app.movies.domain.repository.MovieRepository;

public class MovieHibernateRepository extends BaseHibernateRepository<Movie> implements MovieRepository {

	public MovieHibernateRepository() {

		typeParameterClass = Movie.class;

	}

	@Override
	public List<Movie> getList(Specification<Movie> specification, double minimumRating, int page, int pageSize) {

		CriteriaBuilder cb = this.getSession().getCriteriaBuilder();

		CriteriaQuery<Movie> criteriaQuery = cb.createQuery(specification.getType());
		Root<Movie> root = criteriaQuery.from(specification.getType());
		// get predicate from specification
		Predicate predicate = specification.toPredicate(root, cb);
		// set predicate and execute query
		criteriaQuery.where(cb.and(predicate, cb.greaterThanOrEqualTo(root.get("rating"), minimumRating)));
		
		
		TypedQuery<Movie> indexQuery =  getSession().createQuery(criteriaQuery);
		
//		indexQuery.setFirstResult((page - 1) * pageSize);
//		indexQuery.setMaxResults(pageSize);


		return indexQuery.getResultList();
	}

}
