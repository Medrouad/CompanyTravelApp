package com.adlere.service;

import com.adlere.domain.CustomerSummary;
import com.adlere.domain.Summary;
import com.adlere.domain.Trip;
import com.adlere.domain.DayTrip;
import com.adlere.domain.Tap;

import java.util.*;
import java.util.stream.Collectors;


public class SummaryService {


    /**
     * Build the customer Summary for each customer
     * @param dayTrip : all the trips made by each customer
     * @return object Summary that contains list of CustomerSummary
     */
    public Summary computeBillingSummary(DayTrip dayTrip) {

        Summary tripSummary = new Summary();
        List<CustomerSummary> customerSummaries = new ArrayList<>();

        List<Tap> sortedTaps = sortTapsByCustomerThenByDate(dayTrip);
        Map<Integer, List<Tap>> customerTaps = groupByCustomerId(sortedTaps);

        for (Map.Entry<Integer, List<Tap>> entry : customerTaps.entrySet()) {
            Integer id = entry.getKey();
            List<Tap> list = entry.getValue();
            CustomerSummary customerSummary = new CustomerSummary(id);
            int i = 0;
            while (i < list.size() - 1) {
                Trip trip = Trip.initTrip(list.get(i),list.get(i+1));
                customerSummary.setTotalCostInCents(customerSummary.getTotalCostInCents() + trip.getCostInCents());
                customerSummary.getTrips().add(trip);
                i += 2;
            }
            customerSummaries.add(customerSummary);
        }
        tripSummary.setCustomerSummaries(customerSummaries);

        return tripSummary;
    }

    /**
     * Sort the trip taps made by each customer
     * @param dayTrip : all the trips made by each customer
     * @return List of taps sorted
     */
    public static List<Tap> sortTapsByCustomerThenByDate(DayTrip dayTrip) {
        Comparator<Tap> comparator = Comparator
                .comparing(Tap::getCustomerId)
                .thenComparing(Tap::getUnixTimestamp);
        return dayTrip.getTaps().stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    /**
     * Group the trip taps made by each customer
     * @param taps : all the taps made by customers
     * @return List of taps sorted
     */
    public static Map<Integer, List<Tap>> groupByCustomerId(List<Tap> taps) {
        final Map<Integer, List<Tap>> tripCustomerTaps = new HashMap<>();
        for (Tap tap : taps) {
            tripCustomerTaps.computeIfAbsent(tap.getCustomerId(), t -> new ArrayList<>()).add(tap);
        }
        return tripCustomerTaps;
    }

}
