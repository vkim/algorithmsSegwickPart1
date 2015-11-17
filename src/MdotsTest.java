import java.io.ByteArrayInputStream;

import org.junit.Test;

public class MdotsTest {

	@Test
	public void test() {
		
		StringBuilder sb = new StringBuilder();

		sb.append("4\n");
		sb.append("4 7\n");
		sb.append("1 3\n");
		sb.append("2 5\n");
		sb.append("5 6\n");
		
		String data = sb.toString();
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		Mdots.main(null);
	}
}
