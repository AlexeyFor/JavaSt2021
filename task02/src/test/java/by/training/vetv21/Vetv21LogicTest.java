package by.training.vetv21;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Vetv21LogicTest {

	Vetv21Logic temp = new Vetv21Logic();

	@DataProvider(name = "dataForPleaser")
	public String[][] createDataForPleaser() {
		return new String[][] { { "М", "Мне нравятся мальчики!" }, { "Д", "Мне нравятся девочки!" },
				{ "s", "enter 'Д' or 'М'" }, };
	}

	@Test(description = "test of pleaser()", dataProvider = "dataForPleaser")
	public void testPleaser(String symbol, String result) {
		char ch = symbol.charAt(0);
		String actual = temp.pleaser(ch);
		String expected = result;
		assertEquals(actual, expected);
	}
}