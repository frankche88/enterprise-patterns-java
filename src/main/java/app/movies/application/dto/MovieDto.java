package app.movies.application.dto;

import org.joda.time.DateTime;

public class MovieDto {

	public long id;
	public String name;
	private DateTime releaseDate;
	private String mpaaRating;
	private String genre;
	private double rating;
	private String director;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DateTime getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(DateTime releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getMpaaRating() {
		return mpaaRating;
	}
	public void setMpaaRating(String mpaaRating) {
		this.mpaaRating = mpaaRating;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}

}
