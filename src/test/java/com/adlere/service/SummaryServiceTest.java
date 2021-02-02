package com.adlere.service;

import com.adlere.domain.DayTrip;
import com.adlere.domain.Tap;
import com.adlere.domain.CustomerSummary;
import com.adlere.domain.Summary;
import com.adlere.domain.Trip;
import com.adlere.enums.Station;
import org.junit.jupiter.api.Test;
import com.adlere.service.SummaryService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SummaryServiceTest {

    private DayTrip initDayTrip_A_to_C() {
        DayTrip dayTrip = new DayTrip();
        List<Tap> taps = new ArrayList<>();
        taps.add(new Tap(1, 1, Station.A));
        taps.add(new Tap(4, 1, Station.C));
        dayTrip.setTaps(taps);
        return dayTrip;
    }

    private Summary initCustomerSummaries_A_to_C() {
        Summary tripSummary = new Summary();
        List<CustomerSummary> customerSummaries = new ArrayList<>();
        List<Trip> trips =  Arrays.asList(new Trip(Station.A, Station.C, 1, 240, 1, 2));
        CustomerSummary customerSummary = new CustomerSummary(1, 240, trips);
        customerSummaries.add(customerSummary);
        tripSummary.setCustomerSummaries(customerSummaries);
        return tripSummary;
    }

    @Test
    public void test_computeBillingSummary_A_to_C() {
        DayTrip dayTrip = initDayTrip_A_to_C();
        SummaryService summaryService = new SummaryService();
        Summary expected = initCustomerSummaries_A_to_C();
        Summary summary = summaryService.computeBillingSummary(dayTrip);
        assertEquals(summary, expected);
    }

    private DayTrip initDayTrip_B_C_D_H_G_F() {
        DayTrip dayTrip = new DayTrip();
        List<Tap> taps = new ArrayList<>();
        taps.add(new Tap(3, 2, Station.B));
        taps.add(new Tap(10, 2, Station.C));
        taps.add(new Tap(20, 2, Station.D));
        taps.add(new Tap(25, 2, Station.H));
        taps.add(new Tap(60, 2, Station.G));
        taps.add(new Tap(70, 2, Station.F));
        dayTrip.setTaps(taps);
        return dayTrip;
    }

    private Summary initCustomerSummaries_B_C_D_H_G_F() {
        Summary tripSummary = new Summary();
        List<CustomerSummary> customerSummaries = new ArrayList<>();
        List<Trip> trips = Arrays.asList(
                new Trip(Station.B, Station.C, 3, 240, 1, 2),
                new Trip(Station.D, Station.H, 20, 300, 2, 4),
                new Trip(Station.G, Station.F, 60, 200, 4, 4)
        );
        CustomerSummary customerSummary = new CustomerSummary(2, 740, trips);
        customerSummaries.add(customerSummary);
        tripSummary.setCustomerSummaries(customerSummaries);
        return tripSummary;
    }



    @Test
    public void test_computeBillingSummary_B_C_D_H_G_F() {
        DayTrip dayTrip = initDayTrip_B_C_D_H_G_F();
        SummaryService summaryService = new SummaryService();
        Summary expected = initCustomerSummaries_B_C_D_H_G_F();
        Summary summary = summaryService.computeBillingSummary(dayTrip);
        assertEquals(summary, expected);
    }

    private DayTrip init_trips_for_different_customer() {
        DayTrip dayTrip = new DayTrip();
        List<Tap> taps = new ArrayList<>();
        taps.add(new Tap(1, 1, Station.A));
        taps.add(new Tap(2, 2, Station.D));
        taps.add(new Tap(7, 1, Station.C));
        taps.add(new Tap(4, 1, Station.C));
        taps.add(new Tap(6, 2, Station.F));
        taps.add(new Tap(3, 1, Station.F));
        dayTrip.setTaps(taps);
        return dayTrip;
    }

    @Test
    public void test_sortTapsByCustomerThenByDate() {
       DayTrip dayTrip = init_trips_for_different_customer();
       List<Tap> expected = Arrays.asList(new Tap(1, 1, Station.A),
               new Tap(3, 1, Station.F),
               new Tap(4, 1, Station.C),
               new Tap(7, 1, Station.C),
               new Tap(2, 2, Station.D),
               new Tap(6, 2, Station.F));
       List<Tap> result = SummaryService.sortTapsByCustomerThenByDate(dayTrip);

       assertEquals(expected, result);
    }

}
