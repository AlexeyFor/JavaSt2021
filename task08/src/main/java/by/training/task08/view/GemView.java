package by.training.task08.view;

import java.text.SimpleDateFormat;
import java.util.List;

import by.training.task08.entity.Gem;
import by.training.task08.entity.ProcessedGem;
import by.training.task08.entity.UnprocessedGem;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         methods for showing ProcessedGem and UnprocessedGem
 *
 */
public class GemView {

	private static final GemView instance = new GemView();

	private GemView() {
	}

	public static GemView getInstance() {
		return instance;
	}

	private final SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

	public void showProcessedGem(ProcessedGem gem) {
		System.out.println("ID: " + gem.getID());
		System.out.println("preciousness: " + gem.getPreciousness());
		System.out.println("name: " + gem.getName());
		System.out.println("price: " + gem.getPrice());
		System.out.println("dateOfReceiving: " + formater.format(gem.getDateOfReceiving()));
		System.out.println("originCountry: " + gem.getOriginCountry());
		System.out.println("colour: " + gem.getColour());
		System.out.println("transporancy: " + gem.getTransporancy());
		System.out.println(String.format("weight: %s", gem.getWeight()));
		System.out.println("processedType: " + gem.getProcessedType());
		System.out.println("facesNumber: " + gem.getFacesNumber());

	}

	public void showUnprocessedGem(UnprocessedGem gem) {
		System.out.println("ID: " + gem.getID());
		System.out.println("preciousness: " + gem.getPreciousness());
		System.out.println("name: " + gem.getName());
		System.out.println("price: " + gem.getPrice());
		System.out.println("dateOfReceiving: " + formater.format(gem.getDateOfReceiving()));
		System.out.println("originCountry: " + gem.getOriginCountry());
		System.out.println("colour: " + gem.getColour());
		System.out.println("transporancy: " + gem.getTransporancy());
		System.out.println(String.format("weight: %s", gem.getWeight()));
		System.out.println("height: " + gem.getHeight());
		System.out.println("length: " + gem.getLength());
		System.out.println("width: " + gem.getWidth());

	}

	public void showListOfGem(List<Gem> gems) {
		for (int i = 0; i < gems.size(); i++) {

			Gem gem = gems.get(i);
			if (gem instanceof ProcessedGem) {
				showProcessedGem((ProcessedGem) gems.get(i));
			}
			if (gem instanceof UnprocessedGem) {
				showUnprocessedGem((UnprocessedGem) gems.get(i));
			}
			System.out.println("");
		}
	}
}
