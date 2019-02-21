package gadek.com;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class PracticeTest {

	@Test
	public void TestFibb() {
		assertEquals(1,1);
		Practice pracite = new Practice();
		assertEquals(89,pracite.Fibb(11));
	}
	
	@Test
	public void TestReverseString() {
		
		Practice pracite = new Practice();
		assertEquals("csezC",pracite.reverseString("Czesc"));
		assertEquals("MomentObrotowy",pracite.reverseString("ywotorbOtnemoM"));
		

	}
	@Test
    public void FizzBuzzV2(){
		Practice pracite = new Practice();
			assertEquals("Fizz", pracite.FizzBuzzOneLine(3));
	        assertEquals("Buzz", pracite.FizzBuzzOneLine(5));
	        assertEquals("FizzBuzz", pracite.FizzBuzzOneLine(15));
	        assertEquals("2", pracite.FizzBuzzOneLine(2));
       
    }

}
