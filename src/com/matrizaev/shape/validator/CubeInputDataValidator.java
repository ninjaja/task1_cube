package com.matrizaev.shape.validator;

import com.matrizaev.shape.exception.CubeValidationException;
import com.matrizaev.shape.reader.CubeReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CubeInputDataValidator {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String VALIDATION_EXPRESSION = "-?\\d+\\.\\d+\\s-?\\d+\\.\\d+\\s-?\\d+\\.\\d+\\s\\d+\\.\\d+";

    public List<String> cubeValidate(List<String> listToValidate) throws CubeValidationException {

        ArrayList<String> validatedList = new ArrayList<>();
        Pattern pattern = Pattern.compile(VALIDATION_EXPRESSION);

        for(String string : listToValidate) {
            if(pattern.matcher(string).find()) {
                validatedList.add(string);
            } else {
                LOGGER.log(Level.INFO, "Validation: string [" + string + "] is incorrect");
            }
        }
        if (validatedList.isEmpty()) {
            throw new CubeValidationException("Validation: no correct data found");
        }
        return validatedList;
    }
}
