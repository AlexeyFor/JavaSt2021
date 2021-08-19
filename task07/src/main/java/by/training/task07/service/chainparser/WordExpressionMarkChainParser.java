package by.training.task07.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task07.entity.Component;
import by.training.task07.entity.SentenceComposite;
import by.training.task07.entity.WordExpressionMarkComposite;

public class WordExpressionMarkChainParser extends AbstractChainParser {

    private static final Logger LOG = LogManager.getLogger(WordExpressionMarkChainParser.class);

    public WordExpressionMarkChainParser(AbstractChainParser handler) {
	super();
	this.handler = handler;
    }

    public WordExpressionMarkChainParser() {
	super();
    }

    private AbstractChainParser handler;

    public AbstractChainParser getHandler() {
	return handler;
    }

    public void setHandler(AbstractChainParser handler) {
	this.handler = handler;
    }

    @Override
    public List<Component> chainParser(String str) {
	List<Component> result = new ArrayList<>();
	List<String> wordsMarks = TextParserService.getInstance().parseTextToWordMark(str);
	List<String> expressions = TextParserService.getInstance().parseTextToExpression(str);

	if (this.handler == null) {
	    for (int i = 0; i < wordsMarks.size(); i++) {
		WordExpressionMarkComposite tmp;
		if (wordsMarks.get(i) != null) {
		    // create word or mark
		    LOG.debug("add word or mark: " + wordsMarks.get(i));
		    tmp = new WordExpressionMarkComposite(fromStringToSymbolList(wordsMarks.get(i)),
			    true);
		} else if (expressions.get(i) != null) {
		    // create expression
		    LOG.debug("add expression: " + expressions.get(i));
		    tmp = new WordExpressionMarkComposite(
			    fromStringToSymbolList(expressions.get(i)), false);
		} else {
		    LOG.warn("neither word or mark, no expression in chainParser ");
		    tmp = new WordExpressionMarkComposite(
			    fromStringToSymbolList("wrong word or expression"), true);
		}
		result.add(tmp);
	    }
	} else {
	    for (int i = 0; i < wordsMarks.size(); i++) {
		WordExpressionMarkComposite tmp;
		if (wordsMarks.get(i) != null) {
		    // create word or mark
		    tmp = new WordExpressionMarkComposite(handler.chainParser(wordsMarks.get(i)),
			    true);
		} else if (expressions.get(i) != null) {
		    // create expression
		    tmp = new WordExpressionMarkComposite(handler.chainParser(expressions.get(i)),
			    false);
		} else {
		    LOG.warn("neither word or mark, no expression in chainParser ");
		    tmp = new WordExpressionMarkComposite(
			    fromStringToSymbolList("wrong word or expression"), true);
		}
		result.add(tmp);

	    }

	}
	return result;

    }
}
