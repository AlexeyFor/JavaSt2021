package by.training.task07.service;

import java.util.ArrayList;
import java.util.List;

import by.training.task07.entity.Component;
import by.training.task07.entity.LexemeComposite;
import by.training.task07.entity.ParagraphComposite;

public class ParagraphChainParser extends AbstractChainParser {

    public ParagraphChainParser(AbstractChainParser handler) {
	super();
	this.handler = handler;
    }

    public ParagraphChainParser() {
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
	List<String> paragraphs = TextParserService.getInstance().parseTextToParagraphs(str);

	if (this.handler == null) {
	    for (int i = 0; i < paragraphs.size(); i++) {
		result.add(new ParagraphComposite(fromStringToSymbolList(paragraphs.get(i))));
	    }
	} else {
	    for (int i = 0; i < paragraphs.size(); i++) {
		result.add(new ParagraphComposite(handler.chainParser(paragraphs.get(i))));
	    }
	}
	return result;

    }

}
