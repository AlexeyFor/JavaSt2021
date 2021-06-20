package by.training.service.creator;

import org.testng.annotations.Test;

import by.training.service.ServiceException;

public class WheelCreatorTest {
	WheelCreator tmp = new WheelCreator();

	@Test(description = "negative for createWheel", enabled = true, expectedExceptions = ServiceException.class)
	public void createWheelNegativeTest() throws ServiceException {
		tmp.createWheel(-0.1, "type");
	}
}
