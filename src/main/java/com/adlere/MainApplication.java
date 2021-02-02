package com.adlere;

import com.adlere.domain.DayTrip;
import com.adlere.domain.Summary;
import com.adlere.service.SummaryService;
import com.adlere.utils.InputOutputFileCheck;

import java.io.IOException;

public class MainApplication {

    public static void main(String[] args) throws IOException {

        if (args[0] == null && args[1] == null) {
            System.out.println("input and output are missing ");
        }else if (args[0].trim().isEmpty()) {
            System.out.println("input file is empty");
        }else if (args[1] == null || args[1].trim().isEmpty()) {
            System.out.println("output file is missing or empty");
        } else {
            String fileInput = args[0];
            String fileOutput = args[1];
            InputOutputFileCheck inputOutputFile = new InputOutputFileCheck();
            DayTrip dayTrip = inputOutputFile.readAndValidateFile(fileInput);
            SummaryService summaryService = new SummaryService();
            Summary summary= summaryService.computeBillingSummary(dayTrip);
            InputOutputFileCheck.writeInOutputFile(fileOutput,summary);
        }
    }

}
