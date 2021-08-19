package by.training.task08.service;

import by.training.task08.service.dom.GemDOMService;
import by.training.task08.service.sax.GemSAXService;
import by.training.task08.service.stax.GemStAXService;

public class GemParserFactory {

	public GemParserService takeParser(String name) throws ServiceException {
		GemParserService result;
		Parsers parserName = Parsers.valueOf(name);
		switch (parserName) {
		case DOM:
			result = new GemDOMService();
			break;
		case SAX:
			result = new GemSAXService();
			break;
		case STAX:
			result = new GemStAXService();
			break;
		default:
			throw new ServiceException("wrong_parser");
		}

		return result;
	}
}
