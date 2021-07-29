package by.training.task07.service;

import java.util.ArrayList;
import java.util.List;

import by.training.task07.entity.Component;
import by.training.task07.entity.LexemeComposite;
import by.training.task07.entity.ParagraphComposite;
import by.training.task07.entity.SentenceComposite;

public class SentenceChainParser extends AbstractChainParser {

    public SentenceChainParser(AbstractChainParser handler) {
	super();
	this.handler = handler;
    }

    public SentenceChainParser() {
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
	List<String> sentences = TextParserService.getInstance().parseTextToSentences(str);

	if (this.handler == null) {
	    for (int i = 0; i < sentences.size(); i++) {
		result.add(new SentenceComposite(fromStringToSymbolList(sentences.get(i))));
	    }
	} else {
	    for (int i = 0; i < sentences.size(); i++) {
		result.add(new SentenceComposite(handler.chainParser(sentences.get(i))));
	    }
	}
	return result;

    }
}
