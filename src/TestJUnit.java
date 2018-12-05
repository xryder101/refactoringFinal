import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
  Movie movie = new Movie ("Avengers", 1);
  Rental rent = new Rental (movie, 1);
	@Test
	
   public void movieTest() {
      String str = "Avengers";
      assertEquals(movie.getTitle(),str);
   }
    
	@Test
	
	public void rentalTest() {
		 
		 assertEquals(rent.getMovie(), movie);
		 assertEquals(rent.getDaysRented(), 1);
	}
  
   
}
