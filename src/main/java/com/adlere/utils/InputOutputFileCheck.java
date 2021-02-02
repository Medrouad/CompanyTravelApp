package com.adlere.utils;

import com.adlere.domain.Summary;
import com.adlere.exceptions.CheckFileException;
import com.adlere.exceptions.TripException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.adlere.domain.DayTrip;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InputOutputFileCheck {

       public static DayTrip readAndValidateFile(String filePath) throws IOException {
           File inputFile = new File(filePath);
           if (inputFile.exists() && inputFile.isFile() && inputFile.length() != 0) {
               DayTrip dayTrip = new ObjectMapper().readValue(inputFile, DayTrip.class);
               TripException.validateTripException(dayTrip);
               return dayTrip;
           } else if (!inputFile.exists()) {
               throw new CheckFileException("Input file does not exist");
           } else {
               throw new CheckFileException("Input file has a bad format or null");
           }
       }

       public static void writeInOutputFile(String filePath, Summary summary) throws IOException {
           if (Files.isDirectory(Paths.get(filePath))) {
               throw new CheckFileException("Path file is a directory, please add the file name");
           } else if (Files.notExists(Paths.get(filePath))) {
               throw new CheckFileException("Output file does not exist");
           } else {
               ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
               String jsonOutput = mapper.writeValueAsString(summary);
               Files.write(Paths.get(filePath), jsonOutput.getBytes());
           }
       }

}
