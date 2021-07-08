package by.training.service.creator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.math.BigDecimal;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.training.task05.entity.Sphere;
import by.training.task05.entity.Sphere.CoordinateXYZ;
import by.training.task05.service.RepositoryLogic;
import by.training.task05.service.RepositoryLogicImpl;
import by.training.task05.service.ServiceException;
import by.training.task05.service.ServiceProvider;
import by.training.task05.service.SphereLogic;

public class SphereLogicTest {

    ServiceProvider provider = ServiceProvider.getInstance();
    SphereLogic logic = provider.getSphereLogic();

    @Test(description = "positive for CalculateSquare", dataProvider = "PositiveForCalculateSquare", dataProviderClass = SphereLogicTestData.class)
    public void calculateSquareTestPositive(double radius, BigDecimal expected)
	    throws ServiceException {
	BigDecimal actual = logic.calculateSquare(radius);
	boolean answer = actual.compareTo(expected) == 0;
	assertTrue(answer);
    }

    @Test(description = "positive for CalculateVolume", dataProvider = "PositiveForCalculateVolume", dataProviderClass = SphereLogicTestData.class)
    public void calculateVolumeTestPositive(double radius, BigDecimal expected)
	    throws ServiceException {
	BigDecimal actual = logic.calculateVolume(radius);
//	assertEquals(actual, expected);
	boolean answer = actual.compareTo(expected) == 0;
	assertTrue(answer);
    }

    @BeforeTest
    public void initRep() throws ServiceException {
	RepositoryLogicImpl.getInstance()
		.intiateRepository(System.getProperty("user.dir") + "//data//spheres.txt");
    }

    @Test(description = "positive for calculateCuttingVolumeRatio", dataProvider = "positiveCalculateCuttingVolumeRatio", dataProviderClass = SphereLogicTestData.class)
    public void calculateCuttingVolumeRatioTestPositive(Sphere sphere, CoordinateXYZ first,
	    CoordinateXYZ second, BigDecimal expected) throws ServiceException {
	BigDecimal actual = logic.calculateCuttingVolumeRatio(sphere, first, second);
//	assertEquals(actual, expected);
	boolean answer = actual.compareTo(expected) == 0;
	assertTrue(answer);
    }

///////////// NEGATIVE TESTS
    @Test(description = "negative for calculateVolume", dataProvider = "NegativeForCalculateVolumeSquare", dataProviderClass = SphereLogicTestData.class, enabled = true, expectedExceptions = ServiceException.class)
    public void calculateVolumeNegativeTest(double radius) throws ServiceException {
	logic.calculateVolume(radius);
    }

    @Test(description = "negative for calculateSquare", dataProvider = "NegativeForCalculateVolumeSquare", dataProviderClass = SphereLogicTestData.class, enabled = true, expectedExceptions = ServiceException.class)
    public void calculateSquareNegativeTest(double radius) throws ServiceException {
	logic.calculateSquare(radius);
    }

    @Test(description = "negative for calculateCuttingVolumeRatio", dataProvider = "negativeCalculateCuttingVolumeRatio", dataProviderClass = SphereLogicTestData.class, enabled = true, expectedExceptions = ServiceException.class)
    public void calculateCuttingVolumeRatioTestNegative(Sphere sphere, CoordinateXYZ first,
	    CoordinateXYZ second) throws ServiceException {
	BigDecimal actual = logic.calculateCuttingVolumeRatio(sphere, first, second);
    }

    // check with Sphere = null
    @Test(description = "negative for calculateCuttingVolumeRatio", dataProvider = "negativeCalculateCuttingVolumeRatio", dataProviderClass = SphereLogicTestData.class, enabled = true, expectedExceptions = ServiceException.class)
    public void calculateCuttingVolumeRatioTestNegativeNullShere(Sphere sphere, CoordinateXYZ first,
	    CoordinateXYZ second) throws ServiceException {
	BigDecimal actual = logic.calculateCuttingVolumeRatio(null, first, second);
    }

    // check with CoordinateXYZ = null
    @Test(description = "negative for calculateCuttingVolumeRatio", dataProvider = "negativeCalculateCuttingVolumeRatio", dataProviderClass = SphereLogicTestData.class, enabled = true, expectedExceptions = ServiceException.class)
    public void calculateCuttingVolumeRatioTestNegativeNullCoordinate(Sphere sphere,
	    CoordinateXYZ first, CoordinateXYZ second) throws ServiceException {
	BigDecimal actual = logic.calculateCuttingVolumeRatio(sphere, null, second);
    }
}
