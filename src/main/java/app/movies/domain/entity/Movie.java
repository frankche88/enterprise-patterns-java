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
	protected void setId(long id) {
		this.id = id;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected void setReleaseDate(DateTime releaseDate) {
		this.releaseDate = releaseDate;
	}
	protected void setMpaaRating(MpaaRating mpaaRating) {
		this.mpaaRating = mpaaRating;
	}
	protected void setGenre(String genre) {
		this.genre = genre;
	}
	protected void setRating(double rating) {
		this.rating = rating;
	}
	protected void setDirector(Director director) {
		this.director = director;
	}
	

}
