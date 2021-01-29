package com.exceptions;

import com.domain.DayTrip;

public class TripException {

    public TripException() {}

    public static void validateTripException(DayTrip dayTrip) {
        if(dayTrip == null || dayTrip.getTaps() == null) throw new TripValidationException("No trip is carried out this day, it must be not null");
        if(dayTrip.getTaps().size() % 2 != 0) throw new TripValidationException("Tap is not even, check if someone didn't finished the trip yet");
    }

}
