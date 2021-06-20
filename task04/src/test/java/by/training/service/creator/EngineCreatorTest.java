package by.training.service.creator;

import org.testng.annotations.Test;

import by.training.service.ServiceException;

public class EngineCreatorTest {
  
	EngineCreator tmp = new EngineCreator();

	
	@Test(description = "negative for createEngine", enabled = true, expectedExceptions = ServiceException.class)
	public void createEnginerNegativeTest()
			throws ServiceException {
		tmp.createEngine(-0.1, "type");
	}
}
