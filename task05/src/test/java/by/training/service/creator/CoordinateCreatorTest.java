package by.training.service.creator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.training.task05.entity.Sphere;
import by.training.task05.service.creator.CoordinateCreator;
import by.training.task05.service.creator.CreatorException;

public class CoordinateCreatorTest {

    CoordinateCreator creator = CoordinateCreator.getInstance();

    @DataProvider(name = "createCoordinateNegative")
    public Object[][] createSphereCoordinate() {
	final double MAX = (1.7976931348623157E308);
	final double MIN = (-1.7976931348623157E308);

	return new Object[][] { { 1.0, 1.0, Double.NaN }, { Double.NaN, 1.0, 1.0 },
		{ 1.0, Double.NaN, 1.0 }, { 1.0, 1.0, MAX }, { MAX, 1.0, 1.0 }, { 1.0, MAX, 1.0 },
		{ 1.0, 1.0, MIN }, { MIN, 1.0, 1.0 }, { 1.0, MIN, 1.0 },
		{ 1.0, 1.0, Double.POSITIVE_INFINITY }, { Double.POSITIVE_INFINITY, 1.0, 1.0 },
		{ 1.0, Double.POSITIVE_INFINITY, 1.0 }, { 1.0, 1.0, Double.NEGATIVE_INFINITY },
		{ Double.NEGATIVE_INFINITY, 1.0, 1.0 }, { 1.0, Double.NEGATIVE_INFINITY, 1.0 } };
    }

    @Test(description = "negative for createCoordinate", dataProvider = "createCoordinateNegative", enabled = true, expectedExceptions = CreatorException.class)
    public void createCoordinateNegativeTest1(double x, double y, double z)
	    throws CreatorException {

	creator.createCoordinate(x, y, z);
    }

}
