import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TextBuddyUnitTest {
	
	Logic logic;
	
	@Before
	public void init(){
		String[] args = new String[1];
		args[0] = "test.txt";
		logic = new Logic(args);
	}
	
	@Test
	public void testSort() {
		fail("Not yet implemented");
	}

}
