package com.virtualpairprogrammers.travelbooking;

import com.virtualpairprogrammers.travelbooking.domain.*;
import com.virtualpairprogrammers.travelbooking.exceptions.InvalidTravelDurationException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

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

        ArrayList<TravelTicket> tickets = new ArrayList<>();
        //HashSet<TravelTicket> tickets = new HashSet<>();
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



        //Java 17 only
        if (foundTicket instanceof BusTicket bt) {
            System.out.println(bt.getPermittedProviders());
        }

    }

}
