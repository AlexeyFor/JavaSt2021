package by.training.task07.service;

import java.util.ArrayList;
import java.util.List;

import by.training.task07.entity.Component;
import by.training.task07.entity.WordComposite;

public class WordChainParser extends AbstractChainParser {

    public WordChainParser(AbstractChainParser handler) {
	super();
	this.handler = handler;
    }

    public WordChainParser() {
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
	List<String> words = TextParserService.getInstance().parseTextToWords(str);

	if (this.handler == null) {
	    for (int i = 0; i < words.size(); i++) {
		result.add(new WordComposite(fromStringToSymbolList(words.get(i))));
	    }
	} else {
	    for (int i = 0; i < words.size(); i++) {
		result.add(new WordComposite(handler.chainParser(words.get(i))));
	    }
	}
	return result;

    }
}
