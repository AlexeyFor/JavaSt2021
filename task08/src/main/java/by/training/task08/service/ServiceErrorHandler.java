package by.training.task08.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ServiceErrorHandler implements ErrorHandler {
    private static Logger logger = LogManager.getLogger();

    public void warning(SAXParseException e) throws SAXException {
	logger.warn(getLineColumnNumber(e) + "-" + e.getMessage());
	throw new SAXException(e.getLineNumber() + " : " + e.getColumnNumber());
    }

    public void error(SAXParseException e) throws SAXException {
	logger.error(getLineColumnNumber(e) + " - " + e.getMessage());
	throw new SAXException(e.getLineNumber() + " : " + e.getColumnNumber());

    }

    public void fatalError(SAXParseException e) throws SAXException {
	logger.fatal(getLineColumnNumber(e) + " - " + e.getMessage());
	throw new SAXException(e.getLineNumber() + " : " + e.getColumnNumber());
    }

    private String getLineColumnNumber(SAXParseException e) {
	// determine line and position of error
	return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}
