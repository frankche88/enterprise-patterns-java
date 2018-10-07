package app.movies.infrastructure.persistence.hibernate.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import app.common.domain.specification.AbstractSpecification;
import app.movies.domain.entity.Movie;

public class MovieDirectedBySpecification extends AbstractSpecification<Movie> {

	private static String _director;

	public MovieDirectedBySpecification(final String director) {
		_director = director;
	}

	@Override
	public Predicate toPredicate(Root<Movie> root, CriteriaBuilder cb) {
		
		return cb.equal(root.get("director").get("name"), _director);
	}

	@Override
	public boolean isSatisfiedBy(Movie movie) {
		
		return _director.equals(movie.getDirector().getName());
	}

}
