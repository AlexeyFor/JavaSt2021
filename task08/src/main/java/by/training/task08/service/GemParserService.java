package by.training.task08.service;

import java.util.List;

import by.training.task08.entity.Gem;

public interface GemParserService {

	public List<Gem> takeGemFromXML(String pathXML, String pathXSD) throws ServiceException;
}
