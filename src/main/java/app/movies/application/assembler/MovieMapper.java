package app.movies.application.assembler;

import org.modelmapper.PropertyMap;

import app.movies.application.dto.MovieDto;
import app.movies.domain.entity.Movie;

public class MovieMapper extends PropertyMap<Movie, MovieDto> {

	@Override
	protected void configure() {
		map().setDirector(source.getDirector().getName());
		map().setMpaaRating(source.getMpaaRating().toString());
		
	}

}
