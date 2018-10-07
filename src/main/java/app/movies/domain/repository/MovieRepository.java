package app.movies.domain.repository;

import java.util.List;

import app.common.domain.specification.Specification;
import app.movies.domain.entity.Movie;

public interface MovieRepository {

	List<Movie> getList(Specification<Movie> specification, double minimumRating, int page, int pageSize);

}
