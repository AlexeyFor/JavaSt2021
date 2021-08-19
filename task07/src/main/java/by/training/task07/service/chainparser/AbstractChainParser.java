package by.training.task07.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.task07.entity.Component;
import by.training.task07.entity.SymbolComponent;

public abstract class AbstractChainParser {
    private static final Logger LOG = LogManager.getLogger(AbstractChainParser.class);

    public abstract List<Component> chainParser(String str);

    public List<Component> fromStringToSymbolList(String str) {
	LOG.debug("parse to symbols with " + str);
	List<Component> symbols = new ArrayList<>();
	char[] chars = str.toCharArray();

	for (char ch : chars) {
	    symbols.add(new SymbolComponent(ch));
	}
	return symbols;
    }
}
