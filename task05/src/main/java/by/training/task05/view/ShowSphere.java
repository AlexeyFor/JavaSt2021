package by.training.task05.view;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task05.entity.Sphere;
import by.training.task05.repository.Repository;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         methods for showing Sphere and List <Sphere>
 */
public class ShowSphere {

    private static ShowSphere instance = new ShowSphere();

    private ShowSphere() {
    }

    public static ShowSphere getInstance() {
	return instance;
    }

    private final Repository repository = Repository.getInstance();
    private static final Logger LOG = LogManager.getLogger(ShowSphere.class);

    /**
     * show List <Sphere> without information about Square and Volume
     * 
     * @param list
     */
    public void showListOfSpheresWithoutSquareVolume(List<Sphere> list) {
	LOG.info("start showListOfSpheresWithoutSquareVolume");
	list.forEach(ShowSphere.getInstance()::showSphereWithoutSquareVolume);
    }

    /**
     * show List <Sphere> with full information
     * 
     * @param list
     */
    public void showListOfSpheres(List<Sphere> list) {
	LOG.info("start showListOfSpheres");
	list.forEach(ShowSphere.getInstance()::showSphere);
    }

    /**
     * show Sphere without information about Square and Volume
     * 
     * @param sphere
     */
    public void showSphereWithoutSquareVolume(final Sphere sphere) {
	final String betweenFields = ", ";
	System.out.print("name: " + sphere.getName() + betweenFields);
	System.out.print(String.format("radius: %.5f", sphere.getRadius()) + betweenFields);
	System.out.print(String.format("ID: %s", sphere.getID()) + betweenFields);
	System.out.print(String.format("centerX: %.5f, centerY: %.5f, centerZ: %.5f",
		sphere.getCenterX(), sphere.getCenterY(), sphere.getCenterZ()) + betweenFields);
	System.out.println("");

    }

    /**
     * show Sphere with full information
     * 
     * @param sphere
     */
    public void showSphere(final Sphere sphere) {
	final String betweenFields = ", ";
	final long ID = sphere.getID();
	System.out.print("name: " + sphere.getName() + betweenFields);
	System.out.print(String.format("radius: %.5f", sphere.getRadius()) + betweenFields);
	System.out.print(String.format("ID: %s", ID) + betweenFields);
	System.out.print(String.format("centerX: %.5f, centerY: %.5f, centerZ: %.5f.",
		sphere.getCenterX(), sphere.getCenterY(), sphere.getCenterZ()));
	System.out.print((String.format("square: %.5f, volume: %.5f.",
		repository.getListener(ID).getSquare(), repository.getListener(ID).getVolume())));
	System.out.println("");

    }

}
