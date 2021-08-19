package by.training.task08.tmp8;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task08.entity.Gem;
import by.training.task08.entity.ProcessedGem;
import by.training.task08.entity.UnprocessedGem;
import by.training.task08.service.ServiceException;
import by.training.task08.service.XMLValidator;
import by.training.task08.service.sax.GemSAXBuilder;
import by.training.task08.view.GemView;

public class TMPMainSax {

	private static final Logger LOG = LogManager.getLogger(TMPMainSax.class);

	public static void main(String[] args) throws ServiceException {

		LOG.debug("start");
		String defaultPath = System.getProperty("user.dir") + "//src//main//resources//data//";
		String fileName = defaultPath + "gems.xml";

		String xsdFile = defaultPath + "gems.xsd";
		XMLValidator validator = XMLValidator.getInstance();

		if (validator.validateFile(fileName, xsdFile)) {
			GemSAXBuilder saxBuilder = new GemSAXBuilder(xsdFile);
			saxBuilder.buildListGems(fileName);
			List<Gem> gems = saxBuilder.getGems();

			GemView.getInstance().showListOfGem(gems);
		}

	}
}
