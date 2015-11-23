package stepic;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

public class GCDTest {

	@Test
	public void test() {
		
		StringBuilder sb = new StringBuilder();

		sb.append("18 35\n");
		
		String data = sb.toString();
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		
		GCD.main(null);
	}

}
