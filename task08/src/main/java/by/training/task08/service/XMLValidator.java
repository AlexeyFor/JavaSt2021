package by.training.task08.service;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;


/**
 * 
 * @author AlexeySupruniuk
 * 
 * 
 *
 */
public class XMLValidator {
    private static final Logger LOG = LogManager.getLogger(XMLValidator.class);

    private static final XMLValidator instance = new XMLValidator();

    private XMLValidator() {
    }

    public static XMLValidator getInstance() {
	return instance;
    }

    /**
     * Validate .xml file wit .xsd file
     * 
     * @param filePath
     * @param schemaPath
     * @return
     * @throws ServiceException
     */
    public boolean validateFile(String filePath, String schemaPath) throws ServiceException {
	LOG.info("start validateFile");

	String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
	SchemaFactory factory = SchemaFactory.newInstance(language);
	File schemaLocation = new File(schemaPath);
	try {
	    Schema schema = factory.newSchema(schemaLocation);
	    Validator validator = schema.newValidator();
	    Source source = new StreamSource(filePath);
	    validator.setErrorHandler(new ServiceErrorHandler());
	    validator.validate(source);
	} catch (IOException e) {
	    LOG.debug("can't find file");
	    throw new ServiceException("wrong_file");
	} catch (SAXException e) {
	    throw new ServiceException("error in line " + e.getMessage());

	}
	return true;
    }
}
