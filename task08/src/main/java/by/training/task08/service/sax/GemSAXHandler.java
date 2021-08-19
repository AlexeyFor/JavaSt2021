package by.training.task08.service.sax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import by.training.task08.entity.Gem;
import by.training.task08.entity.ProcessedGem;
import by.training.task08.entity.UnprocessedGem;
import by.training.task08.service.ServiceException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         Handler for SAX-parser
 *
 */
public class GemSAXHandler extends DefaultHandler {

	private static final Logger LOG = LogManager.getLogger(GemSAXHandler.class);
	private List<Gem> gems;
	private Gem current;

	private GemXMLTag currentXmlTag;
	private EnumSet<GemXMLTag> withText;
	private static final String ELEMENT_UNPROCESSEDGEM = "unprocessedGem";
	private static final String ELEMENT_PROCESSEDGEM = "processedGem";

	public GemSAXHandler() {
//		LOG.debug("create GemSAXHandler");
		gems = new ArrayList<>();
		// name - first element of gem, width - last; gem's attributes are not including
		withText = EnumSet.range(GemXMLTag.NAME, GemXMLTag.WIDTH);
	}

	public List<Gem> getGems() {
		return gems;
	}

	/**
	 * work with attributes, if that is not started position (opened tag) goes on
	 */
	public void startElement(String uri, String localName, String qName, Attributes attrs) {
//		LOG.debug("start startElement with uri: " + uri + " ,localName: " + localName + " qName: " + qName);
		if (ELEMENT_UNPROCESSEDGEM.equals(qName)) {
			current = new UnprocessedGem();

			if (attrs.getLength() == 1) {
				current.setID(attrs.getValue(0));
			} else {
				current.setID(attrs.getValue("ID"));
				current.setPreciousness(attrs.getValue("preciousness"));

			}
		} else if (ELEMENT_PROCESSEDGEM.equals(qName)) {
			current = new ProcessedGem();

			if (attrs.getLength() == 1) {
				current.setID(attrs.getValue(0));
			} else {
				current.setID(attrs.getValue("ID"));
				current.setPreciousness(attrs.getValue("preciousness"));

			}
		} else {
			GemXMLTag temp = GemXMLTag.valueOf(qName.toUpperCase());
			if (withText.contains(temp)) {
				currentXmlTag = temp;
			}
		}
	}

	/**
	 * add Gem when find closed tag
	 */
	public void endElement(String uri, String localName, String qName) {
//		LOG.debug("start endElement with uri: " + uri + " ,localName: " + localName + " qName: " + qName);
		if (ELEMENT_UNPROCESSEDGEM.equals(qName)) {
			gems.add(current);
		}
		if (ELEMENT_PROCESSEDGEM.equals(qName)) {
			gems.add(current);
		}
	}

	/**
	 * set field value
	 */
	public void characters(char[] ch, int start, int length) {
//		LOG.debug("start characters ");
		String data = new String(ch, start, length).strip();
		if (currentXmlTag != null) {
			switch (currentXmlTag) {
			case NAME:
				current.setName(data);
				break;
			case PRICE:
				current.setPrice(Integer.parseInt(data));
				break;
			case DATEOFRECEIVING:
				try {
					current.setDateOfReceiving(fromStrToDate(data));
				} catch (ServiceException e) {
					LOG.warn("wrong date in " + current.toString());
				}
				break;
			case ORIGINCOUNTRY:
				current.setOriginCountry(data);
				break;
			case COLOUR:
				current.setColour(data);
				break;
			case TRANSPORANCY:
				current.setTransporancy(Integer.parseInt(data));
				break;
			case WEIGHT:
				current.setWeight(Double.parseDouble(data));
				break;
			case HEIGHT:
				((UnprocessedGem) current).setHeight(Double.parseDouble(data));
				break;
			case LENGTH:
				((UnprocessedGem) current).setLength(Double.parseDouble(data));
				break;
			case WIDTH:
				((UnprocessedGem) current).setWidth(Double.parseDouble(data));
				break;
			case FACESNUMBER:
				((ProcessedGem) current).setFacesNumber(Integer.parseInt(data));
				break;
			case PROCESSEDTYPE:
				((ProcessedGem) current).setProcessedType(data);
				break;
			default:
				throw new EnumConstantNotPresentException(currentXmlTag.getDeclaringClass(), currentXmlTag.name());
			}
		}
		currentXmlTag = null;
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
