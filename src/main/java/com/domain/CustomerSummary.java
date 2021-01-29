package com.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerSummary {

    private int customerId;
    private int totalCostInCents;
    private List<Trip> trips;

    public CustomerSummary() {}

    public  CustomerSummary(int customerId) {
        this.customerId = customerId;
        this.trips = new ArrayList<>();
    }

    public CustomerSummary(int customerId, int totalCostInCents, List<Trip> trips) {
        this.customerId = customerId;
        this.totalCostInCents = totalCostInCents;
        this.trips = trips;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setTotalCostInCents(int totalCostInCents) {
        this.totalCostInCents = totalCostInCents;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getTotalCostInCents() {
        return totalCostInCents;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerSummary that = (CustomerSummary) o;
        return customerId == that.customerId &&
                totalCostInCents == that.totalCostInCents &&
                trips.equals(that.trips);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, totalCostInCents, trips);
    }

    @Override
    public String toString() {
        return "CustomerSummary{" +
                "customerId=" + customerId +
                ", totalCostInCents=" + totalCostInCents +
                ", trips=" + trips +
                '}';
    }
}
