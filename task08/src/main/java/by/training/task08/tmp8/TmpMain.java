package by.training.task08.tmp8;

import java.util.List;


import by.training.task08.service.ServiceException;
import by.training.task08.service.XMLValidator;
import by.training.task08.service.dom.GemDomBuilder;
import by.training.task08.entity.Gem;

import by.training.task08.view.GemView;

public class TmpMain {
	public static void main(String[] args) throws ServiceException {
		String defaultPath = System.getProperty("user.dir") + "//src//main//resources//data//";
		String fileName = defaultPath + "gems.xml";
		String xsdFile = defaultPath + "gems.xsd";
		XMLValidator validator = XMLValidator.getInstance();

		if (validator.validateFile(fileName, xsdFile)) {
			GemDomBuilder domBuilder = new GemDomBuilder(xsdFile);
			domBuilder.buildListGems(fileName);
			List<Gem> gems = domBuilder.getGems();

			GemView.getInstance().showListOfGem(gems);

		}
	}

}
