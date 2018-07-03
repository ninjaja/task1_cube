package test.matrizaev.shape.parser;

import com.matrizaev.shape.exception.CubeValidationException;
import com.matrizaev.shape.parser.CubeParser;
import com.matrizaev.shape.reader.CubeReader;
import com.matrizaev.shape.validator.CubeInputDataValidator;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CubeParserTest {

    CubeReader reader;
    CubeInputDataValidator validator;
    CubeParser parser;
    List<String> listToValidate;
    List<String> listToParse;

    @BeforeTest
    public void setUp() {
        reader = new CubeReader();
        listToValidate = reader.readCube();
        validator = new CubeInputDataValidator();
        try {
            listToParse = validator.cubeValidate(listToValidate);
        } catch (CubeValidationException e) {
            e.printStackTrace();
        }
        parser = new CubeParser();
    }

    @AfterTest
    public void tearDown() {
        reader = null;
        listToValidate = null;
        validator = null;
        listToParse = null;
        parser = null;
    }

    @Test
    public void cubeParseTest() {
        String expected = "[1.0, 2.0, 3.0, 8.1, -3.2, 4.8, 5.1, 12.3, 3.4, -5.1, 2.8, 3.7, -12.2, -6.2, -2.6, 15.8]";
        String actual = parser.cubeParse(listToParse).toString();
        assertEquals(expected, actual);
    }
}
