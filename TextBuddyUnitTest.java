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
		
		//when content is empty
		logic.clear();
		assertEquals("not found", logic.searchKeyword("aaa"));
		
		//when key is empty
		assertEquals("not found", logic.searchKeyword(""));
		
		//key is equal to content
		logic.add(" aaa");
		assertEquals("search is complete",logic.searchKeyword("aaa"));
		assertEquals("1. aaa", logic.displaySearch().get(0));
		
		//when there is more than 1 content;
		logic.clear();
		logic.add(" aaa");
		logic.add(" bbb");
		assertEquals("search is complete",logic.searchKeyword("aaa"));
		assertEquals("1. aaa", logic.displaySearch().get(0));
		assertEquals("search is complete",logic.searchKeyword("bbb"));
		assertEquals("1. bbb", logic.displaySearch().get(0));
		
		//keyword is contained in content
		logic.clear();
		logic.add(" aabb");
		assertEquals("search is complete",logic.searchKeyword("aa"));
		assertEquals("1. aabb", logic.displaySearch().get(0));
		
		////keyword appears more than once
		logic.add(" paaple");
		logic.add(" bbb");
		assertEquals("search is complete", logic.searchKeyword("aa"));
		assertEquals("1. aabb", logic.displaySearch().get(0));
		assertEquals("2. paaple", logic.displaySearch().get(1));
		
		//keyword doesn't appear in database
		assertEquals("not found",logic.searchKeyword("paple"));
		assertEquals(null,logic.displaySearch());
	}

}
