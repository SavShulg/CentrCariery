package com.gridnine.testing;

import java.util.List;

public interface Filter {
    List<Flight> departureCurrentTime(List<Flight> fls);

    List<Flight> beforeDepartureDate(List<Flight> fls);

    void flights (List<Flight> fls);

    List<Flight> moreTwoHours(List<Flight> fls);
}