package gadek.com;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class PracticeTest {

	@Test
	public void TestFibb() {
		assertEquals(1,1);
		Practice practice = new Practice();
		assertEquals(89,practice.Fibb(11));
	}
	
	@Test
	public void TestReverseString() {
		
		Practice practice = new Practice();
		assertEquals("csezC",practice.reverseString("Czesc"));
		assertEquals("Moment Obrotowy",practice.reverseString("ywotorbOtnemoM"));
		

	}
	@Test
    public void FizzBuzzV2(){
		Practice practice = new Practice();
			assertEquals("Fizz", practice.FizzBuzzOneLine(3));
	        assertEquals("Buzz", practice.FizzBuzzOneLine(5));
	        assertEquals("FizzBuzz", practice.FizzBuzzOneLine(15));
	        assertEquals("2", practice.FizzBuzzOneLine(2));
       
    }

}
