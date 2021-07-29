package by.training.task07.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParserService {

    private static final Logger LOG = LogManager.getLogger(TextParserService.class);
    private static final TextParserService instance = new TextParserService();

    private TextParserService() {
    }

    public static TextParserService getInstance() {
	return instance;
    }

    /**
     * Parse text to list of paragraphs
     * 
     * @param text
     * @return
     */
    public List<String> parseTextToParagraphs(String text) {
	LOG.debug("start parseTextToParagraphs with " + '\n' + text);
	final String patternDelimeterParagraph = "([^\\s\t].+)\r\n";
	List<String> result = commonParser(text, patternDelimeterParagraph, 1);
	return result;
    }

    /**
     * Parse text to list of sentences
     * 
     * @param text
     * @return
     */
    public List<String> parseTextToSentences(String text) {
	LOG.debug("start parseTextToSentences with " + '\n' + text);
	final String patternDelimeterSentences = "([^\\s])(.[^\\.\\?\\!]+)((\\.{3})|\\.|(\\!{1}\\?{1})|\\?|\\!)";
	List<String> result = commonParser(text, patternDelimeterSentences, 0);
	return result;
    }

    /**
     * Parse text to list of lexems
     * 
     * @param text
     * @return
     */
    public List<String> parseTextToLexems(String text) {
	LOG.debug("start parseTextToLexems with " + '\n' + text);

	final String patternDelimeterLexems = "([^\\s\t]+?)(\\s|$)";
	List<String> result = commonParser(text, patternDelimeterLexems, 1);
	return result;
    }

    /**
     * Parse text to list of words
     * 
     * @param text
     * @return
     */
    public List<String> parseTextToWords(String text) {
	LOG.debug("start parseTextToWords with " + '\n' + text);
	final String patternDelimeterParagraph = "(\\(?([A-Za-z']+)\\)?)";
	List<String> result = commonParser(text, patternDelimeterParagraph, 1);
	return result;
    }

    /**
     * Parse text to list of wordMark - contain word or mark, work in pair with
     * parseTextExpression. both methods return "linked lists". If the first has
     * null, then the second must have an expression in this place, otherwise -
     * exception
     * 
     * @param text
     * @return
     */
    public List<String> parseTextToWordMark(String text) {
	LOG.debug("start parseTextToWordMark with " + '\n' + text);
	final String patternDelimeterWordMarkExpression = "((\\(?([A-Za-z']+)\\)?)|([0-9<>~&|^\\(\\)]+))(\\s|((\\.{3})|\\.|(\\!{1}\\?{1})|\\?|\\!|,|-|:|;))?";
	List<String> result = commonParserWithTwoGroups(text, patternDelimeterWordMarkExpression, 2,
		5);
	return result;
    }

    /**
     * Parse text to list of exceptions. Work in pair with parseTextToWordMark
     * 
     * @param text
     * @return
     */
    public List<String> parseTextToExpression(String text) {
	LOG.debug("start parseTextToExpression with " + '\n' + text);
	final String patternDelimeterWordMarkExpression = "((\\(?([A-Za-z']+)\\)?)|([0-9<>~&|^\\(\\)]+))(\\s|((\\.{3})|\\.|(\\!{1}\\?{1})|\\?|\\!|,|-|:|;))?";
	List<String> result = commonParser(text, patternDelimeterWordMarkExpression, 4);
	return result;
    }

    private List<String> commonParser(String text, String patternDelimeter, int groupNumber) {

	List<String> components = new ArrayList<>();
	Pattern pat = Pattern.compile(patternDelimeter);
	Matcher match = pat.matcher(text);

	while (match.find()) {
	    components.add(match.group(groupNumber));
	}
	return components;
    }

    private List<String> commonParserWithTwoGroups(String text, String patternDelimeter,
	    int groupNumberFisrt, int groupNumberSecond) {

	List<String> components = new ArrayList<>();
	Pattern pat = Pattern.compile(patternDelimeter);
	Matcher match = pat.matcher(text);

	while (match.find()) {
	    if ((match.start(groupNumberFisrt) != -1) && (match.start(groupNumberSecond) != -1)) {
		components.add(match.group(groupNumberFisrt));
		components.add(match.group(groupNumberSecond));
	    } else if (match.start(groupNumberFisrt) != -1) {
		components.add(match.group(groupNumberFisrt));
	    } else if (match.start(groupNumberSecond) != -1) {
		components.add(match.group(groupNumberSecond));
	    } else {
		components.add(null);
	    }
//	    components.add(tmp);
	}
	return components;
    }
}
