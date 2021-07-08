package by.training.task05.repository.specification.find;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.training.task05.entity.Sphere;

/**
 * 
 * @author AlexeySupruniuk
 * 
 *         Specification for finding Spheres by symbols in name
 * 
 * @param <Sphere>
 */
public class SymbolsFindSpecification extends FindSpecification<Sphere> {

    private String symbols;

    public SymbolsFindSpecification(final String symbols) {
	this.symbols = symbols;
    }

    public void setSymbols(String symbols) {
	this.symbols = symbols;
    }

    /**
     * check, if name of sphere has such symbols
     */
    @Override
    public boolean test(final Sphere tmp) {

	final Pattern pat = Pattern.compile(symbols);
	Matcher match = pat.matcher(tmp.getName());

	if (match.find()) {
	    return true;
	} else {
	    return false;
	}
    }

}
