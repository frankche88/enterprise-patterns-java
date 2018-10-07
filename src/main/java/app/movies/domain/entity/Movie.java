package app.movies.domain.entity;

import org.joda.time.DateTime;

import app.movies.domain.enumeration.MpaaRating;

public class Movie {

	private long id;
	private String name;
	private DateTime releaseDate;
	private MpaaRating mpaaRating;
	private String genre;
	private double rating;
	private Director director;
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public DateTime getReleaseDate() {
		return releaseDate;
	}
	public MpaaRating getMpaaRating() {
		return mpaaRating;
	}
	public String getGenre() {
		return genre;
	}
	public double getRating() {
		return rating;
	}
	public Director getDirector() {
		return director;
	}

}
