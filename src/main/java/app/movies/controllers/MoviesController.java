package app.movies.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import app.common.application.dto.ApiStringResponseDto;
import app.common.domain.specification.AbstractSpecification;
import app.common.domain.specification.Specification;
import app.movies.application.assembler.MovieAssembler;
import app.movies.application.dto.MovieDto;
import app.movies.domain.entity.Movie;
import app.movies.domain.repository.MovieRepository;
import app.movies.infrastructure.persistence.hibernate.specification.AvailableOnCDSpecification;
import app.movies.infrastructure.persistence.hibernate.specification.MovieDirectedBySpecification;
import app.movies.infrastructure.persistence.hibernate.specification.MovieForKidsSpecification;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;

@Path("v1/movies")
@Api(value = "v1/movies")
public class MoviesController {

	@Inject

	private MovieRepository _movieRepository;
	@Inject
	private MovieAssembler _movieAssembler;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@UnitOfWork
	public Response Create(@QueryParam("forKidsOnly") boolean forKidsOnly, @QueryParam("onCD") boolean onCD) {

		float minimumRating = 4;

		try {

			Specification<Movie> specification = getMovieSpecification(forKidsOnly, onCD);
			// TODO: Validations with Notification Pattern
			List<Movie> movies = _movieRepository.getList(specification, minimumRating, 1, 5);

			List<MovieDto> moviesDto = _movieAssembler.toDtoList(movies);
			return Response.ok(moviesDto).build();
		} catch (Exception ex) {

			ex.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new ApiStringResponseDto("Internal Server Error")).build();
			// Console.WriteLine(ex.StackTrace);
			// return StatusCode(StatusCodes.Status500InternalServerError, new
			// ApiStringResponseDto("Internal Server Error"));

		}
	}

	private Specification<Movie> getMovieSpecification(boolean forKidsOnly, boolean onCD) {
		AbstractSpecification<Movie> specification = null;
		
		if(!forKidsOnly && !onCD) {
			return new MovieDirectedBySpecification("Bill Condon");
		}
		
		if(forKidsOnly && onCD) {
			specification = new MovieForKidsSpecification();
			return specification = specification.and(new AvailableOnCDSpecification());
		}

		if (forKidsOnly)
			return new MovieForKidsSpecification();
		if (onCD)
			return new AvailableOnCDSpecification();
		// spec = new MovieDirectedBySpecification("Marc Webb");
		return specification;
	}

}
