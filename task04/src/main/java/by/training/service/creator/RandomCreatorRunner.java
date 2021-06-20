package by.training.service.creator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import by.training.dal.DALException;
import by.training.dal.WorkWithFileImpl;
import by.training.entity.Car;
import by.training.entity.Engine;
import by.training.entity.Wheel;
import by.training.service.ServiceException;
import by.training.view.ViewCar;

/**
 * For creation random Car and save them into file
 * 
 * due to the fact that the data is taken from Google, there may be errors
 * during creation (nuances when copying text)
 * 
 * @author AlexeySupruniuk
 *
 * 
 */
public class RandomCreatorRunner {

	public static void main(String[] args) throws ServiceException, JsonProcessingException, DALException {

		CarRandomCreator creator = CarRandomCreator.getInstance();
		creator.setDefaultData();
		ViewCar view = ViewCar.getInstance();
		Car car = creator.createRandomCar();

		final String defaultPath = System.getProperty("user.dir") + "//src//main//java//by//training//source//";
		String name = "randomCar.txt";

		ObjectMapper mp = new ObjectMapper();
		WorkWithFileImpl reader = WorkWithFileImpl.getInstance();
		String saved = mp.writeValueAsString(car);
		System.out.println(reader.writeInFile(saved, defaultPath + name));

	}

}
