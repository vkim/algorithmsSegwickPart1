import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class ShellTest {

	@Test
	public void test() {
		String[] a = new String[]{"17", "66", "16", "11", "33", "97", "83", "41", "47", "59" };
		Shell.sort(a);
		
		System.out.println("a: " + Arrays.toString(a));
	}
	
	@Test
	public void testSelection() {
		
		String[] a = new String[]{"17", "66", "16", "11", "33", "97", "83", "41", "47", "59" };
		
		Selection.sort(a)
		;
		
		System.out.println("b: " + Arrays.toString(a));
	}

}
