package christmasMovies;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovieTest {

	Movie movie;
	Rating rating;
	Genre genre;
	int year;
	int movieId;
	String title;
	boolean familyFriendly;
	
	@BeforeEach
	void setUp() throws Exception {
		movie = new Movie();
		
		title = "The Grinch";
		genre = Genre.FANTASY;
		year = 2005;
		movieId=12345;
		rating = Rating.PG_13;
		familyFriendly = true;
	}

	@Test
	void testGetSetMovieId() {
		movie.setMovieId(movieId);
		assertEquals(movieId,movie.getMovieId());
	}

	@Test
	void testGetSetTitle() {
		movie.setTitle(title);
		assertEquals(title,movie.getTitle());
	}

	@Test
	void testGetSetYear() {
		movie.setYear(year);
		assertEquals(year, movie.getYear());
	}

	@Test
	void testGetSetRating() {
		movie.setRating(rating);
		assertEquals(rating, movie.getRating());
	}

	@Test
	void testGetSetFamilyFriendly() {
		movie.setFamilyFriendly(familyFriendly);
		assertTrue(movie.isFamilyFriendly());
	}

	@Test
	void testGetSetGenre() {
		movie.setGenre(genre);
		assertEquals(genre, movie.getGenre());
	}

}
