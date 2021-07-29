package by.training.task07.service.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task07.entity.ExpressionElement;
import by.training.task07.service.ServiceException;

public class ExpressionFomLexemeService {

    private static ExpressionFomLexemeService instance = new ExpressionFomLexemeService();

    private ExpressionFomLexemeService() {
    }

    public static ExpressionFomLexemeService getInstance() {
	return instance;
    }

    private static final Logger LOG = LogManager.getLogger(ExpressionFomLexemeService.class);

    private final Pattern pattternForOneSymbolExpr = Pattern.compile("[\\Q()|^&~\\E]");
    private final Pattern pattternForMoreLessSymbol = Pattern.compile("[><]");
    private final Pattern pattternForNumber = Pattern.compile("[0-9]");

    /**
     * Take Lexeme and convert it into List <ExpressionElement>
     * 
     * @param expression
     * @return
     * @throws ServiceException
     */
    public List<ExpressionElement> fromStringToExpressionList(String expression)
	    throws ServiceException {
	LOG.debug("start fromLexemeToExpressionList with " + expression.toString());
	char[] expressionArray = expression.toCharArray();
	List<ExpressionElement> result = fromCharArrayToExpressionElementList(expressionArray);
	return result;
    }

//    private char[] fromLexemeToCharArray(Lexeme expression) {
//	List<SymbolComponent> symbols = expression.getLexeme();
//	char[] answer = new char[symbols.size()];
//
//	for (int i = 0; i < symbols.size(); i++) {
//	    answer[i] = symbols.get(i).getValue();
//	}
//
//	return answer;
//    }

    /**
     * 
     * @param expressionArray
     * @return List<ExpressionElement>
     * @throws ServiceException
     */
    private List<ExpressionElement> fromCharArrayToExpressionElementList(char[] expressionArray)
	    throws ServiceException {

	int i = 0;
	ExpressionElement resultElement;

	Matcher match;

	List<ExpressionElement> result = new ArrayList<>();

	while (i < expressionArray.length) {

	    // check for ( ) | ^ & ~
	    String tmp = String.valueOf(expressionArray[i]);
	    match = pattternForOneSymbolExpr.matcher(tmp);
	    if (match.find()) {
		resultElement = fromStrToExpressionElementOne(tmp);
		result.add(resultElement);
		i++;
		continue;
	    }

	    // check for << and <<<
	    match = pattternForMoreLessSymbol.matcher(tmp);
	    if (match.find()) {
		resultElement = fromStrToExpressionElementMoreLess(expressionArray, i);
		result.add(resultElement);
		i += stepForCycle(resultElement);
		continue;
	    }

	    // check for number
	    match = pattternForNumber.matcher(tmp);
	    if (match.find()) {
		resultElement = fromStrToExpressionElementNumber(expressionArray, i);
		result.add(resultElement);
		i += stepForCycle(resultElement);
	    }
	}

	return result;
    }

    /**
     * for elements ()|^&~
     * 
     * @param str
     * @return
     * @throws ServiceException
     */
    private ExpressionElement fromStrToExpressionElementOne(String str) throws ServiceException {

	switch (str) {
	case ("("):
	    return new ExpressionElement("(", 1);
	case ("|"):
	    return new ExpressionElement("|", 2);
	case ("^"):
	    return new ExpressionElement("^", 3);
	case ("&"):
	    return new ExpressionElement("&", 4);
	case ("~"):
	    return new ExpressionElement("~", 6);
	case (")"):
	    return new ExpressionElement(")", 7);
	default:
	    LOG.debug("wrong sybol in  fromStrToExpressionElementOne: " + str);
	    throw new ServiceException("wrong_symbol");
	}
    }

    /**
     * for elements << >> >>>
     * 
     * @param str
     * @return
     * @throws ServiceException
     */
    private ExpressionElement fromStrToExpressionElementMoreLess(char[] expressionArray, int index)
	    throws ServiceException {

	String str = new String(expressionArray, index, 2);
	switch (str) {
	case ("<<"):
	    return new ExpressionElement("<<", 5);
	case (">>"):
	    String tmp = new String(expressionArray, index, 3);
	    if (tmp.equals(">>>")) {
		return new ExpressionElement(">>>", 5);

	    } else {
		return new ExpressionElement(">>", 5);
	    }
	default:
	    LOG.debug("wrong sybol in  fromStrToExpressionElementMoreLess: " + str);
	    throw new ServiceException("wrong_symbol");
	}

    }

    /**
     * for numbers
     * 
     * @param str
     * @return
     * @throws ServiceException
     */
    private ExpressionElement fromStrToExpressionElementNumber(char[] expressionArray, int index) {

	int i = 0;
	String resultStr;
	resultStr = String.valueOf(expressionArray[index + i]);
	Matcher match;
	match = pattternForNumber.matcher(resultStr);

	while (match.find()) {
	    i++;
	    if ((index + i) >= expressionArray.length) {
		break;
	    }
	    resultStr = String.valueOf(expressionArray[index + i]);
	    match = pattternForNumber.matcher(resultStr);

	}

	resultStr = new String(expressionArray, index, i);
	return new ExpressionElement(resultStr, 0);

    }

    /**
     * returns the number by which to increment the cycle variable (i)
     * 
     * @param element
     * @return
     */
    private int stepForCycle(ExpressionElement element) {
	int result;
	result = element.getValue().length();
	return result;
    }
}
