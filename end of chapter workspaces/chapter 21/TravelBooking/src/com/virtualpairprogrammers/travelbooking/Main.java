package com.virtualpairprogrammers.travelbooking;

import com.virtualpairprogrammers.travelbooking.bookingProcess.BookingSystem;
import com.virtualpairprogrammers.travelbooking.bookingProcess.CheapTravelBookingSystem;
import com.virtualpairprogrammers.travelbooking.bookingProcess.EnjoyableToursBookingSystem;
import com.virtualpairprogrammers.travelbooking.domain.*;
import com.virtualpairprogrammers.travelbooking.exceptions.InvalidTravelDurationException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

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

//        System.out.println(tickets.get(1));
//
//        for (int i = 0; i < tickets.size(); i++) {
//            System.out.println(tickets.get(i));
//        }

        for ( TravelTicket b: tickets) {
            System.out.println(b);
        }

        TravelTicket foundTicket = tickets.get(2);
        System.out.println(foundTicket);

        if (foundTicket instanceof BusTicket) {
            System.out.println("This is a bus ticket");
            BusTicket foundBusTicket = (BusTicket) foundTicket;
            System.out.println(foundBusTicket.getPermittedProviders());
        }
        else if (foundTicket instanceof TrainTicket) {
            System.out.println("This is a train ticket");
        } else {
            System.out.println("This is a plane ticket");
        }

        BusTicket bustTicket3 = new BusTicket(foundTicket, providers);

        BookingSystem bookingSystem = new CheapTravelBookingSystem();

        bookingSystem.setTravelTicket(bustTicket3);
        bookingSystem.requestBooking();
        System.out.println("The booking status is " + bookingSystem.getStatus());

//
//        //Java 17 only
//        if (foundTicket instanceof BusTicket bt) {
//            System.out.println(bt.getPermittedProviders());
//        }

        List<Integer> integerList1 = new ArrayList<>();
        integerList1.add(1);
        integerList1.add(2);
        integerList1.add(3);
        integerList1.add(4);
        integerList1.add(5);

        List<Integer> intergerList2 = List.of(1,2,3,4,5);
        for (Integer i: intergerList2) {
            System.out.println(i);
        }
        System.out.println(intergerList2.getClass());

        integerList1.add(6);
        //intergerList2.add(6);

        System.out.println(BookingSystem.getVersion());

        BookingSystem bookingSystem2 = BookingSystem.of(trainTicket);
    }

}
