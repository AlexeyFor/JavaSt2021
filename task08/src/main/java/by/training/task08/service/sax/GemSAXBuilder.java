package by.training.task08.service.sax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import by.training.task08.entity.Gem;
import by.training.task08.service.ServiceErrorHandler;
import by.training.task08.service.ServiceException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         SAX-builder for gems.xml
 *
 */
public class GemSAXBuilder {

	private static final Logger LOG = LogManager.getLogger(GemSAXBuilder.class);

	private List<Gem> gems;
	private GemSAXHandler handler = new GemSAXHandler();
	private XMLReader reader;

	/**
	 * constructor with creating of Schema
	 * 
	 * @param schemaLocation
	 * @throws ServiceException
	 */
	public GemSAXBuilder(String schemaLocation) throws ServiceException {

		Schema schema = createSchema(schemaLocation);
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(true);
		factory.setSchema(schema);

		try {
			SAXParser saxParser = factory.newSAXParser();
			reader = saxParser.getXMLReader();
		} catch (ParserConfigurationException e) {
			LOG.debug("can't create SAXParser");
			throw new ServiceException("can't create SAXParser");
		} catch (SAXException e) {
			LOG.debug("error in XML file");
			throw new ServiceException("wrong_xml");
		}

		reader.setErrorHandler(new ServiceErrorHandler());
		reader.setContentHandler(handler);
	}

	public List<Gem> getGems() {
		return gems;
	}

	/**
	 * create Gem objects from .xml file at path filename
	 * 
	 * @param filename
	 * @throws ServiceException
	 */
	public void buildListGems(String filename) throws ServiceException {
		try {
			reader.parse(filename);
		} catch (IOException e) {
			LOG.debug("can't find file on path " + filename);
			throw new ServiceException("wrong_file");
		} catch (SAXException e) {
			LOG.debug("error in XML file");
			throw new ServiceException("wrong_xml");
		}
		gems = handler.getGems();
	}

	/**
	 * create Schema from .xsd file from schemaLocation
	 * 
	 * @param schemaLocation
	 * @return
	 * @throws ServiceException
	 */
	private Schema createSchema(String schemaLocation) throws ServiceException {
		LOG.debug("start createSchema with schemaLocation " + schemaLocation);

		String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory factory = SchemaFactory.newInstance(language);
		try {
			File schemaFile = new File(schemaLocation);
			return factory.newSchema(schemaFile);
		} catch (SAXException e) {
			LOG.debug("can't create Schema");
			throw new ServiceException("can't create Schema");
		}

	}
}
