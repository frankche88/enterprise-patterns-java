package app.movies.application.assembler;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import app.movies.application.dto.MovieDto;
import app.movies.domain.entity.Movie;

public class MovieAssembler {

	private final ModelMapper _mapper;

	public MovieAssembler() {
		_mapper = new ModelMapper();
	}

	public Movie toEntity(MovieDto bankAccountCreateDto) {
		return _mapper.map(bankAccountCreateDto, Movie.class);
	}

	public MovieDto toDto(Movie movie) {

		return _mapper.typeMap(Movie.class, MovieDto.class)
				.addMapping(src -> src.getDirector().getName(), MovieDto::setDirector).map(movie);

	}

	public List<MovieDto> toDtoList(List<Movie> movieList) {

		List<MovieDto> lstDtoMovies = new ArrayList<>();

		for (Movie movie : movieList) {
			lstDtoMovies.add(toDto(movie));
		}

		return lstDtoMovies;
	}

}
