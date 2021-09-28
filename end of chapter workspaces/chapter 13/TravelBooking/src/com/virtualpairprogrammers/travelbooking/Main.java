package com.virtualpairprogrammers.travelbooking;

import com.virtualpairprogrammers.travelbooking.domain.BusTicket;
import com.virtualpairprogrammers.travelbooking.domain.PlaneTicket;
import com.virtualpairprogrammers.travelbooking.domain.TrainTicket;
import com.virtualpairprogrammers.travelbooking.domain.TravelTicket;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        TrainTicket trainTicket = new TrainTicket();
        trainTicket.cancel();

        TrainTicket trainTicket2 = new TrainTicket(123L,"London","Edinburgh", new BigDecimal("59.00"),
                LocalDateTime.of(2021,9,30,16,03),
                LocalDateTime.of(2022,3,7,19,03),
                1, 3, 42);

        trainTicket2.upgrade();

        String[] providers = {"First bus company", "Second bus company"};

        BusTicket busTicket = new BusTicket(124L,"London","Edinburgh", new BigDecimal("59.00"),
                LocalDateTime.of(2021,9,30,16,03),
                LocalDateTime.of(2022,3,7,19,03),providers);

        trainTicket2.cancel();
        busTicket.cancel();

        //TravelTicket ticket = new TravelTicket();
        PlaneTicket planeTicket = new PlaneTicket();

    }

}
