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
		//when contents is empty
		logic.clear();
		assertEquals("content is empty",logic.sortByAlpha());

		//adding contents
		logic.add(" aaa");
		assertEquals("1. aaa",logic.display().get(0));

		//checking first item in list
		assertEquals("content is sorted", logic.sortByAlpha());
		assertEquals("1. aaa", logic.display().get(0)); 

		//changing contents
		logic.clear();
		logic.add(" bbb");
		logic.add(" aaa");
		assertEquals("content is sorted", logic.sortByAlpha());
		assertEquals("1. aaa", logic.display().get(0));
		assertEquals("2. bbb", logic.display().get(1));

	}

	@Test
	public void testSearch(){
		fail("not implemented");
	}

}
