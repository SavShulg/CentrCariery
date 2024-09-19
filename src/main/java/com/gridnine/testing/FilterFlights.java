package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterFlights implements Filter{
    @Override
    public List<Flight> beforeDepartureDate(List<Flight> fls) {
        List<Flight> listArrivalBeforeDeparture = fls.stream().filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
        listArrivalBeforeDeparture.stream().forEach(System.out::println);
        return listArrivalBeforeDeparture;
    }

    @Override
    public List<Flight> departureCurrentTime(List<Flight> fls) {
        List<Flight> listBeforeNowDate = fls.stream().filter(flight -> flight.getSegments().stream()
                .anyMatch(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now()))).collect(Collectors.toList());
        listBeforeNowDate.stream().forEach(System.out::println);
        return listBeforeNowDate;
    }

    @Override
    public void flights(List<Flight> fls) {
        fls.stream().forEach(System.out::println);
    }
    @Override
    public List<Flight> moreTwoHours(List<Flight> fls) {
        List<Flight> listMoreTwoHours = new ArrayList<>();
        for (Flight flight : fls) {
            List<Segment> segments = flight.getSegments();
            for (int i = 0; i < segments.size() - 1; i++) {
                LocalDateTime depTime = segments.get(i + 1).getDepartureDate();
                LocalDateTime arrTime = segments.get(i).getArrivalDate();
                if (depTime.isAfter(arrTime.plusHours(2))) {
                    listMoreTwoHours.add(flight);
                }
            }
        }
        listMoreTwoHours.stream().forEach(System.out::println);
        return listMoreTwoHours;
    }
}