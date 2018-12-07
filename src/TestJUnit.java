import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
	// Initialize variables
	private final Movie movie = new Movie("Avengers", Movie.REGULAR);
	private final Rental rental = new Rental(movie, 3);
	private final Customer customer = new Customer("Arnold");

	/*** Movie ***/

	// Test getPriceCode
	@Test
	public void testGetPriceCode() {
		int pc = movie.getPriceCode();
		assertEquals(pc, Movie.REGULAR);
	}

	// Test setPriceCode
	@Test
	public void testSetPriceCode() {
		movie.setPriceCode(Movie.CHILDREN);
		int pc = movie.getPriceCode();
		assertEquals(pc, Movie.CHILDREN);
	}

	// Test getTitle
	@Test
	public void testGetTitle() {
		String title = movie.getTitle();
		assertEquals(title, "Avengers");
	}

	/*** Rental ***/

	// Test getDaysRented
	@Test
	public void testGetDaysRented() {
		int gdr = rental.getDaysRented();
		assertEquals(gdr, 3);
	}

	// Test getMovie
	@Test
	public void testGetMovie() {
		final Movie m = rental.getMovie();
		assertEquals(m.getTitle(), movie.getTitle());
		assertEquals(m.getPriceCode(), movie.getPriceCode());
	}

	/*** Customer ***/

	// Test getName
	@Test
	public void testGetName() {
		String name = customer.getName();
		assertEquals(name, "Arnold");
	}

	// Test statement
	@Test
	public void testStatement() {
		// Expected printout
		String line1 = "Rental record for Arnold";
		String line2 = "transformers";
		String line3 = "bled";
		String line4 = "Amount owed is 3.5";
		String line5 = "You earned 2 frequent renter points";

		String reference = line1 + "\n" + "\t" + line2 + "\t" + 1.5 + "\n" + "\t" + line3 + "\t" + 2.0 + "\n" + line4
				+ "\n" + line5;

		// Setup a test case involving movies and rentals
		Movie snow = new Movie("transformers", Movie.CHILDREN);
		Rental snowRental = new Rental(snow, 3);

		Movie gone = new Movie("bled", Movie.REGULAR);
		Rental goneRental = new Rental(gone, 1);

		customer.addRental(snowRental);
		customer.addRental(goneRental);

		// Check generated receipt against reference
		String receipt = customer.statement();
		assertEquals(receipt, reference);
	}
}