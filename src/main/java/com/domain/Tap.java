package com.domain;

import com.enums.Station;

import java.util.Objects;

public class Tap {
    private long unixTimestamp;
    private int customerId;
    private Station station;

    public Tap(long unixTimestamp, int customerId, Station station) {
        this.unixTimestamp = unixTimestamp;
        this.customerId = customerId;
        this.station = station;
    }

    public Tap() {}

    public long getUnixTimestamp() {
        return unixTimestamp;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Station getStation() {
        return station;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tap tap = (Tap) o;
        return unixTimestamp == tap.unixTimestamp &&
                customerId == tap.customerId &&
                Objects.equals(station, tap.station);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unixTimestamp, customerId, station);
    }

    @Override
    public String toString() {
        return "Tap{" +
                "unixTimestamp=" + unixTimestamp +
                ", customerId=" + customerId +
                ", station='" + station + '\'' +
                '}';
    }

}
