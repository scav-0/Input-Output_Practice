package christmasMovies;

public class Movie {
	private int movieId;
	private String title;
	private int year;
	private Rating rating;
	private Genre genre;
	private boolean familyFriendly;
	/**
	 * @return the movieId
	 */
	public int getMovieId() {
		return movieId;
	}
	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the rating
	 */
	public Rating getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	/**
	 * @return the familyFriendly
	 */
	public boolean isFamilyFriendly() {
		return familyFriendly;
	}
	/**
	 * @param familyFriendly the familyFriendly to set
	 */
	public void setFamilyFriendly(boolean familyFriendly) {
		this.familyFriendly = familyFriendly;
	}
	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	
	public void display() {
		System.out.println("Movie Id        :"+this.movieId);
		System.out.println("Title           : "+this.title);
		System.out.println("Year            : "+this.year);
		System.out.println("Rating          : "+this.rating);
		System.out.println("Genre           : "+this.genre);
		System.out.println("Family friendly : "+((this.familyFriendly)?"Yes":"No"));
		System.out.println();
	}
}
