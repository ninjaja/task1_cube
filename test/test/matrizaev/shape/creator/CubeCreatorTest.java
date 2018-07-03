package test.matrizaev.shape.creator;

import com.matrizaev.shape.creator.CubeCreator;
import com.matrizaev.shape.entity.Cube;
import com.matrizaev.shape.exception.CubeValidationException;
import com.matrizaev.shape.parser.CubeParser;
import com.matrizaev.shape.reader.CubeReader;
import com.matrizaev.shape.validator.CubeInputDataValidator;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CubeCreatorTest {

    CubeReader reader;
    CubeInputDataValidator validator;
    CubeParser parser;
    CubeCreator creator;
    List<String> listToValidate;
    List<String> listToParse;
    List<Double> parsedList;
    List<Cube> listOfCubes;

    @BeforeTest
    public void setUp() {
        reader = new CubeReader();
        validator = new CubeInputDataValidator();
        parser = new CubeParser();
        creator = new CubeCreator();
        listToValidate = reader.readCube();
        try {
            listToParse = validator.cubeValidate(listToValidate);
        } catch (CubeValidationException e) {
            e.printStackTrace();
        }
        parsedList = parser.cubeParse(listToValidate);

    }

    @AfterTest
    public void tearDown() {
        reader = null;
        validator = null;
        parser = null;
        creator = null;
        listToValidate = null;
        listToParse = null;
        parsedList = null;
        listOfCubes = null;
    }

    @Test
    public void cubeParseTest() {
        String expected = "[Cube (center coordinates: x=1.0, y=2.0, z=3.0, side length: 8.1), " +
                "Cube (center coordinates: x=-3.2, y=4.8, z=5.1, side length: 12.3), " +
                "Cube (center coordinates: x=2.1, y=6.7, z=-4.6, side length: -6.7), " +
                "Cube (center coordinates: x=3.4, y=-5.1, z=2.8, side length: 3.7), " +
                "Cube (center coordinates: x=-12.2, y=-6.2, z=-2.6, side length: 15.8)]";
        String actual = creator.createCubeList(parsedList).toString();
        assertEquals(expected, actual);

    }


}
