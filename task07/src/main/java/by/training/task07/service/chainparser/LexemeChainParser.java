package by.training.task07.service;

import java.util.ArrayList;
import java.util.List;

import by.training.task07.entity.Component;
import by.training.task07.entity.LexemeComposite;
import by.training.task07.entity.SentenceComposite;

public class LexemeChainParser extends AbstractChainParser {

    public LexemeChainParser(AbstractChainParser handler) {
	super();
	this.handler = handler;
    }

    public LexemeChainParser() {
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
	List<String> lexems = TextParserService.getInstance().parseTextToLexems(str);

	if (this.handler == null) {
	    for (int i = 0; i < lexems.size(); i++) {
		result.add(new LexemeComposite(fromStringToSymbolList(lexems.get(i))));
	    }

	} else {
	    for (int i = 0; i < lexems.size(); i++) {
		result.add(new LexemeComposite(handler.chainParser(lexems.get(i))));
	    }
	}
	return result;

    }
}
