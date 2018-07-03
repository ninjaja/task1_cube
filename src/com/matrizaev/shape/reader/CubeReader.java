package com.matrizaev.shape.reader;

import com.matrizaev.shape.exception.CubeFilePathException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CubeReader {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String FILENAME = "./inputFiles/input.txt";

    public List<String> readCube(String filePath) throws CubeFilePathException {

        if (filePath.trim().isEmpty() || !new File(filePath).exists()) {
            throw new CubeFilePathException("Cannot read the data file from the specified filepath");
        }
        List<String> cubeSourceDataList = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            cubeSourceDataList = stream.collect(Collectors.toList());
            LOGGER.log(Level.INFO, "CubeReader: reading cube data from custom filepath: " + filePath);
        } catch (IOException e) {
            LOGGER.log(Level.WARN, "CubeReader: reading failure from custom filepath: " + filePath);
        }
        LOGGER.log(Level.INFO, "CubeReader: " + cubeSourceDataList.size() + " lines have been read.");
        return cubeSourceDataList;
    }

    public List<String> readCube() {

        List<String> cubeSourceDataList = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(FILENAME))) {
            cubeSourceDataList = stream.collect(Collectors.toList());
            LOGGER.log(Level.INFO, "CubeReader: reading cube data from default filepath: ./inputFiles/input.txt");
        } catch (IOException e) {
            LOGGER.log(Level.WARN, "CubeReader: reading failure from default filepath: ./inputFiles/input.txt");
        }
        LOGGER.log(Level.INFO, "CubeReader: " + cubeSourceDataList.size() + " lines have been read.");
        return cubeSourceDataList;
    }
}
