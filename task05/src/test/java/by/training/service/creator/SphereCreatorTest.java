package by.training.service.creator;

import static org.testng.Assert.assertFalse;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.training.task05.entity.Sphere;
import by.training.task05.service.creator.CreatorException;
import by.training.task05.service.creator.SphereCreator;

public class SphereCreatorTest {

    SphereCreator creator = SphereCreator.getInstance();

    @DataProvider(name = "createSphereCoordinateNegative")
    public Object[][] createSphereCoordinate() {
	final double MAX = (1.7976931348623157E308);
	return new Object[][] { { "русскоеИмя", new Sphere.CoordinateXYZ(0, 0, 0), 1 },
		{ "name", new Sphere.CoordinateXYZ(0, 0, 0), 0 },
		{ "name", new Sphere.CoordinateXYZ(0, 0, 0), Double.POSITIVE_INFINITY },
		{ "name", new Sphere.CoordinateXYZ(0, 0, 0), Double.NEGATIVE_INFINITY },
		{ "name", new Sphere.CoordinateXYZ(0, 0, 0), Double.NaN },
		{ "name", new Sphere.CoordinateXYZ(0, 0, 0), -5 },
		{ "name", new Sphere.CoordinateXYZ(MAX, 0, 0), 20 },
		{ "name", new Sphere.CoordinateXYZ(0, MAX, 0), 20 },
		{ "name", new Sphere.CoordinateXYZ(0, 0, MAX), 1 }, };
    }

    @DataProvider(name = "createSphereNegative")
    public Object[][] createSphere() {
	final double MAX = (1.7976931348623157E308);
	return new Object[][] { { "русскоеИмя", 0, 0, 0, 1 }, { "name", 0, 0, 0, 0 },
		{ "name", 0, 0, 0, Double.POSITIVE_INFINITY },
		{ "name", 0, 0, 0, Double.NEGATIVE_INFINITY },
		{ "name", Double.POSITIVE_INFINITY, 0, 0, 5 },
		{ "name", 0, Double.POSITIVE_INFINITY, 0, 5 },
		{ "name", 0, 0, Double.POSITIVE_INFINITY, 5 },
		{ "name", Double.NEGATIVE_INFINITY, 0, 0, 5 },
		{ "name", 0, Double.NEGATIVE_INFINITY, 0, 5 },
		{ "name", 0, 0, Double.NEGATIVE_INFINITY, 5 },
		{ "name", Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0, 5 },
		{ "name", 0, 0, Double.NaN, 5 }, { "name", Double.NaN, 0, Double.NaN, 5 },
		{ "name", Double.NaN, 0, 0, 5 }, { "name", 0, Double.NaN, 0, 5 },
		{ "name", 0, 0, 0, Double.NaN }, { "name", 0, 0, 0, -5 }, { "name", MAX, 0, 0, 20 },
		{ "name", 0, MAX, 0, 20 }, { "name", 0, 0, MAX, 1 }, };
    }

    @DataProvider(name = "setSphereRadiusFalse")
    public Object[][] setSphereRadius() throws CreatorException {
	final double MAX = (1.7976931348623157E308);
	Sphere sphere1 = creator.createSphere("name", new Sphere.CoordinateXYZ(1, 1, 1), 5);

	return new Object[][] { { sphere1, Double.POSITIVE_INFINITY }, { sphere1, Double.NaN },
		{ sphere1, Double.NEGATIVE_INFINITY }, { sphere1, 0 }, { sphere1, -5 },
		{ sphere1, MAX } };
    }

    @Test(description = "negative for createSphere1", dataProvider = "createSphereCoordinateNegative", enabled = true, expectedExceptions = CreatorException.class)
    public void createSphereNegativeTest1(String name, Sphere.CoordinateXYZ center, double radius)
	    throws CreatorException {

	creator.createSphere(name, center, radius);
    }

    @Test(description = "negative for createSphere", dataProvider = "createSphereNegative", enabled = true, expectedExceptions = CreatorException.class)
    public void createSphereNegativeTest2(String name, double coordinateX, double coordinateY,
	    double coordinateZ, double radius) throws CreatorException {

	creator.createSphere(name, coordinateX, coordinateY, coordinateZ, radius);
    }

    @Test(description = "negative for createSphere2 (for null)", enabled = true, expectedExceptions = CreatorException.class)
    public void createSphereNegativeTest3() throws CreatorException {

	creator.createSphere("name", null, 5);
    }

    @Test(description = "setSphereRadius (false)", dataProvider = "setSphereRadiusNegative")
    public void setSphereRadiusNegativeTest(Sphere sphere, double radius) throws CreatorException {

	boolean answer = creator.setSphereRadius(sphere, radius);
	assertFalse(answer);
    }
}
