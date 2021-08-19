package by.training.task08.service.stax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task08.entity.Gem;
import by.training.task08.entity.ProcessedGem;
import by.training.task08.entity.UnprocessedGem;
import by.training.task08.service.ServiceException;
import by.training.task08.service.dom.GemDomBuilder;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         StAX-builder for gems.xml
 *
 */
public class GemStAXBuilder {

	private static final Logger LOG = LogManager.getLogger(GemStAXBuilder.class);

	private List<Gem> gems;

	public GemStAXBuilder() {
		gems = new ArrayList<>();
	}

	public List<Gem> getGems() {
		return gems;
	}

	/**
	 * Set List<Gem> gems with StAX
	 * 
	 * @param fileName
	 * @throws ServiceException
	 */
	public void buildListGems(String fileName) throws ServiceException {
		Gem gem = null;
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try {
			XMLEventReader reader = inputFactory.createXMLEventReader(new FileInputStream(fileName));
			while (reader.hasNext()) {
				XMLEvent event = reader.nextEvent();

				// set all atributes
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					if (startElement.getName().getLocalPart().equals("unprocessedGem")) {
						gem = new UnprocessedGem();
						Attribute ID = startElement.getAttributeByName(new QName("ID"));
						gem.setID(ID.getValue());
						Attribute preciousness = startElement.getAttributeByName(new QName("preciousness"));
						if (preciousness != null) {
							gem.setPreciousness(preciousness.getValue());
						}
					} else if (startElement.getName().getLocalPart().equals("processedGem")) {
						gem = new ProcessedGem();
						Attribute ID = startElement.getAttributeByName(new QName("ID"));
						gem.setID(ID.getValue());
						Attribute preciousness = startElement.getAttributeByName(new QName("preciousness"));
						if (preciousness != null) {
							gem.setPreciousness(preciousness.getValue());
						}
						// set other fields
					} else if (startElement.getName().getLocalPart().equals("name")) {
						event = reader.nextEvent();
						gem.setName(event.asCharacters().getData());

					} else if (startElement.getName().getLocalPart().equals("price")) {
						event = reader.nextEvent();
						gem.setPrice(Integer.parseInt(event.asCharacters().getData()));

					} else if (startElement.getName().getLocalPart().equals("weight")) {
						event = reader.nextEvent();
						gem.setWeight(Double.parseDouble(event.asCharacters().getData()));

					} else if (startElement.getName().getLocalPart().equals("dateOfReceiving")) {
						event = reader.nextEvent();
						gem.setDateOfReceiving(fromStrToDate(event.asCharacters().getData()));

						// check for .isCharacters() because originCountry can be without any value
					} else if (startElement.getName().getLocalPart().equals("originCountry")) {
						event = reader.nextEvent();
						if (event.isCharacters()) {
							gem.setOriginCountry(event.asCharacters().getData());
						}

					} else if (startElement.getName().getLocalPart().equals("colour")) {
						event = reader.nextEvent();
						gem.setColour(event.asCharacters().getData());

					} else if (startElement.getName().getLocalPart().equals("transporancy")) {
						event = reader.nextEvent();
						gem.setTransporancy(Integer.parseInt(event.asCharacters().getData()));

					} else if (startElement.getName().getLocalPart().equals("processedType")) {
						event = reader.nextEvent();
						((ProcessedGem) gem).setProcessedType(event.asCharacters().getData());

					} else if (startElement.getName().getLocalPart().equals("facesNumber")) {
						event = reader.nextEvent();
						((ProcessedGem) gem).setFacesNumber(Integer.parseInt(event.asCharacters().getData()));

					} else if (startElement.getName().getLocalPart().equals("height")) {
						event = reader.nextEvent();
						((UnprocessedGem) gem).setHeight(Double.parseDouble(event.asCharacters().getData()));

					} else if (startElement.getName().getLocalPart().equals("length")) {
						event = reader.nextEvent();
						((UnprocessedGem) gem).setLength(Double.parseDouble(event.asCharacters().getData()));

					} else if (startElement.getName().getLocalPart().equals("width")) {
						event = reader.nextEvent();
						((UnprocessedGem) gem).setWidth(Double.parseDouble(event.asCharacters().getData()));

					}
				}
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart().equals("unprocessedGem")) {
						gems.add(gem);
					}
					if (endElement.getName().getLocalPart().equals("processedGem")) {
						gems.add(gem);
					}
				}
			}
		} catch (FileNotFoundException e) {
			LOG.debug("can't find file");
			throw new ServiceException("wrong_file");
		} catch (XMLStreamException e) {
			LOG.debug("error in XML file");
			throw new ServiceException("wrong_xml");

		}
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
