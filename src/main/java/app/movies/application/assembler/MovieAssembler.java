package app.movies.application.assembler;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import app.movies.application.dto.MovieDto;
import app.movies.domain.entity.Movie;

public class MovieAssembler {

	private final ModelMapper _mapper;

	public MovieAssembler() {
		_mapper = new ModelMapper();
	}

	public Movie toEntity(MovieDto bankAccountCreateDto) {
		_mapper.addMappings(new MovieMapper());
		return _mapper.map(bankAccountCreateDto, Movie.class);
	}

	public List<MovieDto> toDtoList(List<Movie> movieList) {

		Type listType = new TypeToken<List<MovieDto>>() {}.getType();
		return _mapper.map(movieList, listType);
	}

}
