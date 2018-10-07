package app.movies.infrastructure.persistence.hibernate.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import app.common.domain.specification.AbstractSpecification;
import app.movies.domain.entity.Movie;
import app.movies.domain.enumeration.MpaaRating;

public class MovieForKidsSpecification extends AbstractSpecification<Movie> {

	@Override
	public Predicate toPredicate(Root<Movie> root, CriteriaBuilder cb) {
		
		return cb.equal(root.get("mpaaRating"), MpaaRating.PG);
	}

	@Override
	public boolean isSatisfiedBy(Movie movie) {
		return MpaaRating.PG == movie.getMpaaRating();
	}

}
