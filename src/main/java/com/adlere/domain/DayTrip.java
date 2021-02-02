package com.adlere.domain;

import java.util.List;
import java.util.Objects;

public class DayTrip {

    private List<Tap> taps;

    public List<Tap> getTaps() {
        return taps;
    }

    public void setTaps(List<Tap> taps) {
        this.taps = taps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayTrip tripTap = (DayTrip) o;
        return taps.equals(tripTap.taps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taps);
    }
}
