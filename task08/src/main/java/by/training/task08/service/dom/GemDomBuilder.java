package by.training.task08.service.dom;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.training.task08.entity.Gem;
import by.training.task08.entity.ProcessedGem;
import by.training.task08.entity.UnprocessedGem;
import by.training.task08.service.ServiceException;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         DOM-builder for gems.xml
 *
 */
public class GemDomBuilder {

	private static final Logger LOG = LogManager.getLogger(GemDomBuilder.class);

	private List<Gem> gems;
	private DocumentBuilder docBuilder;

	/**
	 * Create DocumentBuilder from DocumentBuilderFactory with Schema from
	 * schemaLocation (.xsd file)
	 * 
	 * @param schemaLocation
	 * @throws ServiceException
	 */
	public GemDomBuilder(String schemaLocation) throws ServiceException {

		LOG.info("start GemDomBuilder with schemaLocation " + schemaLocation);
		gems = new ArrayList<>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		Schema schema = createSchema(schemaLocation);
		// now, docBuilder can see the namespace and will work with Schema
		factory.setNamespaceAware(true);
		factory.setSchema(schema);
		try {
			docBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			LOG.debug("can't create DocumentBuilder");
			throw new ServiceException("can't create DocumentBuilder");
		}
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

	public List<Gem> getGems() {
		return gems;
	}

	/**
	 * take Gem objects from .xml file at path filename
	 * 
	 * @param filename
	 * @throws ServiceException
	 */
	public void buildListGems(String filename) throws ServiceException {
		LOG.info("start buildSetGems with filename " + filename);

		Document doc;
		try {

			doc = docBuilder.parse(filename);
			Element rootProcessed = doc.getDocumentElement();
			// getting a list of <Gem> child elements
			NodeList gemsListProcessed = rootProcessed.getElementsByTagName("processedGem");
			for (int i = 0; i < gemsListProcessed.getLength(); i++) {
				Element gemElement = (Element) gemsListProcessed.item(i);
				Gem gem = buildProcessedGem(gemElement);
				gems.add(gem);
			}

			Element rootUnrocessed = doc.getDocumentElement();
			// getting a list of <Gem> child elements
			NodeList gemsListUnrocessed = rootUnrocessed.getElementsByTagName("unprocessedGem");
			for (int i = 0; i < gemsListUnrocessed.getLength(); i++) {
				Element gemElement = (Element) gemsListUnrocessed.item(i);
				Gem gem = buildUnprocessedGem(gemElement);
				gems.add(gem);
			}
		} catch (IOException e) {
			LOG.debug("can't find file on path " + filename);
			throw new ServiceException("wrong_file");
		} catch (SAXException e) {
			LOG.debug("error in XML file");
			throw new ServiceException("wrong_xml");
		}
	}

	private Gem buildProcessedGem(Element gemElement) throws ServiceException {
		ProcessedGem gem = new ProcessedGem();
		gem.setID(gemElement.getAttribute("ID"));
		gem.setPreciousness(gemElement.getAttribute("preciousness"));
		gem.setName(getElementTextContent(gemElement, "name"));
		Integer price = Integer.parseInt(getElementTextContent(gemElement, "price"));
		gem.setPrice(price);
		Double weight = Double.parseDouble(getElementTextContent(gemElement, "weight"));
		gem.setWeight(weight);
		gem.setDateOfReceiving(fromStrToDate(getElementTextContent(gemElement, "dateOfReceiving")));
		gem.setOriginCountry(getElementTextContent(gemElement, "originCountry"));
		gem.setColour(getElementTextContent(gemElement, "colour"));
		Integer transporancy = Integer.parseInt(getElementTextContent(gemElement, "transporancy"));
		gem.setTransporancy(transporancy);
		gem.setProcessedType(getElementTextContent(gemElement, "processedType"));
		Integer facesNumber = Integer.parseInt(getElementTextContent(gemElement, "facesNumber"));
		gem.setFacesNumber(facesNumber);

		return gem;
	}

	private Gem buildUnprocessedGem(Element gemElement) throws ServiceException {
		UnprocessedGem gem = new UnprocessedGem();
		gem.setID(gemElement.getAttribute("ID"));
		gem.setPreciousness(gemElement.getAttribute("preciousness"));
		gem.setName(getElementTextContent(gemElement, "name"));
		Integer price = Integer.parseInt(getElementTextContent(gemElement, "price"));
		gem.setPrice(price);
		Double weight = Double.parseDouble(getElementTextContent(gemElement, "weight"));
		gem.setWeight(weight);

		gem.setDateOfReceiving(fromStrToDate(getElementTextContent(gemElement, "dateOfReceiving")));
		gem.setOriginCountry(getElementTextContent(gemElement, "originCountry"));
		gem.setColour(getElementTextContent(gemElement, "colour"));
		Integer transporancy = Integer.parseInt(getElementTextContent(gemElement, "transporancy"));
		gem.setTransporancy(transporancy);
		Double height = Double.parseDouble(getElementTextContent(gemElement, "height"));
		gem.setHeight(height);
		Double length = Double.parseDouble(getElementTextContent(gemElement, "length"));
		gem.setLength(length);
		Double width = Double.parseDouble(getElementTextContent(gemElement, "width"));
		gem.setWidth(width);

		return gem;
	}

	/**
	 * get the text content of the tag
	 * 
	 * @param element
	 * @param elementName
	 * @return
	 */
	private String getElementTextContent(Element element, String elementName) {
		NodeList nList = element.getElementsByTagName(elementName);
		Node node = nList.item(0);
		String text = node.getTextContent();
		return text;
	}

	/**
	 * convert String into right-formated date
	 * 
	 * @param str
	 * @return
	 * @throws ServiceException
	 */
	private Date fromStrToDate(String str) throws ServiceException {
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date result = formater.parse(str);
			return result;
		} catch (ParseException e) {
			LOG.debug("wrong date in xml");
			throw new ServiceException("wrong_xml_date");
		}
	}
}
