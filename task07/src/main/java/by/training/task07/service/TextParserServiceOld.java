package by.training.task07.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParserServiceOld {

    public List<String> commonParser(String text, String patternDelimeter, int groupNumber) {

	List<String> components = new ArrayList<>();
	Pattern pat = Pattern.compile(patternDelimeter);
	Matcher match = pat.matcher(text);

	while (match.find()) {
	    components.add(match.group(groupNumber));
	}
	return components;
    }
}
