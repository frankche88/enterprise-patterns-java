package app.movies.infrastructure.persistence.hibernate.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.joda.time.DateTime;

import app.common.domain.specification.AbstractSpecification;
import app.movies.domain.entity.Movie;

public class AvailableOnCDSpecification extends AbstractSpecification<Movie> {
	
	private static final int MonthsBeforeDVDIsOut = 6;

	@Override
	public Predicate toPredicate(Root<Movie> root, CriteriaBuilder cb) {
		
		
		final Path<DateTime> ReleaseDate = root.<DateTime> get("releaseDate");
		
		return cb.lessThanOrEqualTo(ReleaseDate, DateTime.now().minusMonths(MonthsBeforeDVDIsOut));
	}

	@Override
	public boolean isSatisfiedBy(Movie movie) {
		
		return !movie.getReleaseDate().isAfter(DateTime.now().minusMonths(MonthsBeforeDVDIsOut));
		
	}

}
