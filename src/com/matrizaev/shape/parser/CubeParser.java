package com.matrizaev.shape.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CubeParser {

        private static final String PARSE_EXPRESSION = "-?\\d+\\.\\d+";

        public List<Double> cubeParse(List<String> listToParse) {

        ArrayList<Double> parsedList = new ArrayList<>();

        Pattern pattern = Pattern.compile(PARSE_EXPRESSION);

        for (String s: listToParse) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                Double parsedNumber = Double.parseDouble(matcher.group());
                parsedList.add(parsedNumber);
            }
        }
        return parsedList;
    }

}
