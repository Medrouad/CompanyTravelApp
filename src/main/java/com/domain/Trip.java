package com.domain;

import com.service.PricingService;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.enums.Station;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class Trip implements Serializable {

     @JsonProperty("stationStart")
     private Station stationStart;
     @JsonProperty("stationEnd")
     private Station stationEnd;
     @JsonProperty("startedJourneyAt")
     private long startedJourneyAt;
     @JsonProperty("costInCents")
     private int costInCents;
     @JsonProperty("zoneFrom")
     private int zoneFrom;
     @JsonProperty("zoneTo")
     private int zoneTo;

    public Trip() {}

    public Trip(Station stationStart, Station stationEnd, long startedJourneyAt, int costInCents, int zoneFrom, int zoneTo) {
        this.stationStart = stationStart;
        this.stationEnd = stationEnd;
        this.startedJourneyAt = startedJourneyAt;
        this.costInCents = costInCents;
        this.zoneFrom = zoneFrom;
        this.zoneTo = zoneTo;
    }

    public static Trip initTrip(Tap tapStart, Tap tapEnd) {
        Trip trip = new Trip();
        trip.setStationStart(tapStart.getStation());
        trip.setStationEnd(tapEnd.getStation());
        trip.setStartedJourneyAt(tapStart.getUnixTimestamp());
        Map.Entry<Integer, List<Integer>> mapPrice = PricingService.getTheLowestPrice(tapStart.getStation(), tapEnd.getStation());
        trip.setCostInCents(mapPrice.getKey());
        trip.setZoneFrom(mapPrice.getValue().get(0));
        trip.setZoneTo(mapPrice.getValue().get(1));
        return trip;
    }

    public void setStationStart(Station stationStart) { this.stationStart = stationStart; }

    public void setStationEnd(Station stationEnd) {
        this.stationEnd = stationEnd;
    }

    public void setStartedJourneyAt(long startedJourneyAt) {
        this.startedJourneyAt = startedJourneyAt;
    }

    public void setCostInCents(int costInCents) {
        this.costInCents = costInCents;
    }

    public void setZoneFrom(int zoneFrom) {
        this.zoneFrom = zoneFrom;
    }

    public void setZoneTo(int zoneTo) {
        this.zoneTo = zoneTo;
    }

    public int getCostInCents() {
        return costInCents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return startedJourneyAt == trip.startedJourneyAt &&
                costInCents == trip.costInCents &&
                zoneFrom == trip.zoneFrom &&
                zoneTo == trip.zoneTo &&
                stationStart == trip.stationStart &&
                stationEnd == trip.stationEnd;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationStart, stationEnd, startedJourneyAt, costInCents, zoneFrom, zoneTo);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "stationStart=" + stationStart +
                ", stationEnd=" + stationEnd +
                ", startedJourneyAt=" + startedJourneyAt +
                ", costInCents=" + costInCents +
                ", zoneFrom=" + zoneFrom +
                ", zoneTo=" + zoneTo +
                '}';
    }
}
