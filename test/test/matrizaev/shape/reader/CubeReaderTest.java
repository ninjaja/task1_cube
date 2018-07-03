package test.matrizaev.shape.reader;

import com.matrizaev.shape.exception.CubeFilePathException;
import com.matrizaev.shape.reader.CubeReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;

public class CubeReaderTest {
    private static final Logger LOGGER = LogManager.getLogger();

    CubeReader readerDefaultFile;
    CubeReader readerCustomFile;

    @BeforeClass
    public void setUp() {
        readerDefaultFile = new CubeReader();
        readerCustomFile = new CubeReader();
    }

    @AfterClass
    public void tearDown() {
        readerDefaultFile = null;
        readerCustomFile = null;
    }

    @Test
    public void readCubeTestDefaultPath() {
        String expected = "[1.0 2.0 3.0 8.1, -3.2 4.8 5.1 12.3, 2.1 6.7 -4.6 -6.7, 3.4 -5.1 2.8 3.7, -12.2 -6.2 -2.6 15.8]";
        String actual = readerDefaultFile.readCube().toString();
        assertEquals(expected, actual);
    }

    @Test
    public void readCubeTestCustomPath() {
        String expected = "[1.0 2.0 3.0 8.1, -3.2 4.8 5.1 12.3, 2.1 6.7 -4.6 -6.7, 3.4 -5.1 2.8 3.7, -12.2 -6.2 -2.6 15.8]";
        String actual = null;
        try {
            actual = readerDefaultFile.readCube("./inputFiles/input.txt").toString();
        } catch (CubeFilePathException e) {
            LOGGER.log(Level.WARN, "CubeReaderTest: reading failure from custom filepath");
        }
        assertEquals(expected, actual);
    }

    @Test (expectedExceptions = CubeFilePathException.class)
    public void readCubeTestException() throws CubeFilePathException {
        readerCustomFile.readCube("./inputFiles/1234.txt");
    }
}
