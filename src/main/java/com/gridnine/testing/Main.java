package com.gridnine.testing;

import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();
        Filter fil = new FilterFlights();

        System.out.println("Сегменты с датой прибытия раньше даты отъезда:");
        fil.beforeDepartureDate(flights);
        System.out.println();

        System.out.println("Сегменты с датой отправления, предшествующей текущему моменту времени:");
        fil.departureCurrentTime(flights);
        System.out.println();

        System.out.println("Все полеты:");
        fil.flights(flights);
        System.out.println();

        System.out.println("Участки с общим временем пребывания на земле более двух часов:");
        fil.moreTwoHours(flights);
        System.out.println();
    }
}
