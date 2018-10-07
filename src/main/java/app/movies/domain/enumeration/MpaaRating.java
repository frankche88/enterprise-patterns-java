package app.movies.domain.enumeration;

public enum MpaaRating {

	Undefined(0), G(1), PG(2), PG13(3), R(4);

	private int rating = 0;

	public int getRating() {
		return rating;
	}

	MpaaRating(int rating) {

		this.rating = rating;

	}

}
