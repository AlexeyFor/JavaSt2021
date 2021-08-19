package by.training.task08.service.stax;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task08.entity.Gem;
import by.training.task08.service.GemParserService;
import by.training.task08.service.ServiceException;
import by.training.task08.service.XMLValidator;

public class GemStAXService implements GemParserService {

	private static final Logger LOG = LogManager.getLogger(GemStAXService.class);

	public List<Gem> takeGemFromXML(String pathXML, String pathXSD) throws ServiceException {
		LOG.info("start takeGemFromXML with pathXML: " + pathXML + " ,pathXSD: " + pathXSD);

		XMLValidator validator = XMLValidator.getInstance();

		if (validator.validateFile(pathXML, pathXSD)) {
			GemStAXBuilder staxBuilder = new GemStAXBuilder();
			staxBuilder.buildListGems(pathXML);
			List<Gem> gems = staxBuilder.getGems();

			return gems;
		} else {
			throw new ServiceException("wrong_xml");
		}

	}
}
