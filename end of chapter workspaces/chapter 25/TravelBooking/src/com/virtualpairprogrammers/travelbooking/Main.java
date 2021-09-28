package com.virtualpairprogrammers.travelbooking;

import com.virtualpairprogrammers.travelbooking.bookingProcess.BookingSystem;
import com.virtualpairprogrammers.travelbooking.bookingProcess.CheapTravelBookingSystem;
import com.virtualpairprogrammers.travelbooking.bookingProcess.EnjoyableToursBookingSystem;
import com.virtualpairprogrammers.travelbooking.domain.*;
import com.virtualpairprogrammers.travelbooking.exceptions.InvalidTravelDurationException;
import com.virtualpairprogrammers.travelbooking.utilities.OriginSortComparator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws InvalidTravelDurationException {

        TrainTicket trainTicket = new TrainTicket();
        trainTicket.cancel();

        TrainTicket trainTicket2 = null;
        try {
            trainTicket2 = new TrainTicket(123L,"London","Edinburgh", new BigDecimal("59.00"),
                    LocalDateTime.of(2022,3,7,20,03),
                    LocalDateTime.of(2022,3,7,21,03),
                    TravelClass.FIRST, 3, 42);
            trainTicket2.upgrade();
            trainTicket2.cancel();
        } catch (InvalidTravelDurationException e) {
           // e.printStackTrace();
        }


        ArrayList<String> providers = new ArrayList<>();
        providers.add("First bus company");
        providers.add("Second bus company");
        providers.add("Third bus company");

        System.out.println(providers.size());
        System.out.println(providers);

        providers.remove(1);

        System.out.println(providers.size());
        System.out.println(providers);

        BusTicket busTicket = null;

        busTicket = new BusTicket(124L,"London","Edinburgh", new BigDecimal("59.00"),
                    LocalDateTime.of(2021,9,30,16,03),
                    LocalDateTime.of(2022,3,7,19,03),providers);

        BusTicket busTicket2 = new BusTicket(125L,"New York","Boston", new BigDecimal("59.00"),
                LocalDateTime.of(2021,9,30,16,03),
                LocalDateTime.of(2022,3,7,19,03),providers);

        BusTicket busTicket3 = new BusTicket(126L,"Paris","Calais", new BigDecimal("59.00"),
                LocalDateTime.of(2021,9,30,16,03),
                LocalDateTime.of(2022,3,7,19,03),providers);

        List<TravelTicket> tickets = new ArrayList<>();

        tickets.add(busTicket);
        tickets.add(busTicket2);
        tickets.add(busTicket2);
        tickets.add(busTicket2);
        tickets.add(busTicket2);
        tickets.add(busTicket3);
        tickets.add(trainTicket2);

        // Collections.sort(tickets);
        //Collections.sort(tickets, new OriginSortComparator());

        //var add2numbers = (int a, int b) -> {return a + b;};

        BiFunction<TravelTicket, TravelTicket, Integer> departureTimeSort = (TravelTicket a, TravelTicket b) -> {
            return a.getDepartureTime().compareTo(b.getDepartureTime());
        };

//        Collections.sort(tickets, new Comparator<TravelTicket>() {
//            @Override
//            public int compare(TravelTicket o1, TravelTicket o2) {
//                return o1.getDestination().compareTo(o2.getDestination());
//            }
//        });

        Collections.sort(tickets, (a, b) -> a.getDepartureTime().compareTo(b.getDepartureTime()) );

        for ( TravelTicket b: tickets) {
            System.out.println(b);
        }

        tickets.stream().forEach( a -> System.out.println(a) );

        System.out.println("---");

        tickets.stream().filter( a -> a.getOrigin().equals("London")).forEach( a -> System.out.println(a));

        List<TravelTicket> londonTickets = tickets.stream().filter(a -> a.getOrigin().equals("London")).toList();
        //Pre java 17 version
        List<TravelTicket> londonTickets2 = tickets.stream().filter(a -> a.getOrigin().equals("London")).collect(Collectors.toList());

        System.out.println("---");

        for(TravelTicket t : londonTickets) {
            System.out.println(t);
        }

        tickets.stream().map( a -> {
            a.setPrice(a.getPrice().add(new BigDecimal("20")));
            return a;
        }).forEach(a -> System.out.println(a));

    }

}
