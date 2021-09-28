package com.virtualpairprogrammers.travelbooking;

import com.virtualpairprogrammers.travelbooking.domain.*;
import com.virtualpairprogrammers.travelbooking.exceptions.InvalidTravelDurationException;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        TrainTicket trainTicket = new TrainTicket();
        trainTicket.cancel();

        TrainTicket trainTicket2 = null;
        try {
            trainTicket2 = new TrainTicket(123L,"London","Edinburgh", new BigDecimal("59.00"),
                    LocalDateTime.of(2022,3,7,20,03),
                    LocalDateTime.of(2022,3,7,19,03),
                    TravelClass.FIRST, 3, 42);
            trainTicket2.upgrade();
            trainTicket2.cancel();
        } catch (InvalidTravelDurationException e) {
            e.printStackTrace();
        }



        String[] providers = {"First bus company", "Second bus company"};

        BusTicket busTicket = null;
        try {
            busTicket = new BusTicket(124L,"London","Edinburgh", new BigDecimal("59.00"),
                    LocalDateTime.of(2021,9,30,16,03),
                    LocalDateTime.of(2022,3,7,19,03),providers);
        } catch (InvalidTravelDurationException e) {
            e.printStackTrace();
        }


        busTicket.cancel();

        //TravelTicket ticket = new TravelTicket();
        PlaneTicket planeTicket = new PlaneTicket();

    }

}
