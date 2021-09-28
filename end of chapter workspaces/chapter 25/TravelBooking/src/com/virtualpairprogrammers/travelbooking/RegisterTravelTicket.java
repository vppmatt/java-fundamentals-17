package com.virtualpairprogrammers.travelbooking;

import com.virtualpairprogrammers.travelbooking.domain.BusTicket;
import com.virtualpairprogrammers.travelbooking.domain.PlaneTicket;
import com.virtualpairprogrammers.travelbooking.domain.TrainTicket;
import com.virtualpairprogrammers.travelbooking.domain.TravelClass;
import com.virtualpairprogrammers.travelbooking.exceptions.InvalidTravelDurationException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

public class RegisterTravelTicket {
    public static void main(String[] args) throws InvalidTravelDurationException {
        Scanner scanner = new Scanner(System.in);

        int option = 0;

        while (!(option >= 1 && option <= 3)) {
            System.out.println("Enter 1 for bus ticket, 2 for train ticket or 3 for plane ticket");
            option = scanner.nextInt();
        }

        System.out.println("Enter the booking ref");
        Long ref = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Enter the origin");
        String origin = scanner.nextLine();

        System.out.println("Enter the destination");
        String destination = scanner.nextLine();

        System.out.println("Enter the price");
        BigDecimal price = scanner.nextBigDecimal();
        scanner.nextLine();

        System.out.println("Enter the departure time");
        String dTime = scanner.nextLine();
        LocalDateTime departureTime = LocalDateTime.parse(dTime);

        System.out.println("Enter the arrival time");
        String aTime = scanner.nextLine();
        LocalDateTime arrivalTime = LocalDateTime.parse(aTime);

        switch (option) {
            case 1:
                BusTicket busTicket = new BusTicket(ref, origin, destination, price, departureTime, arrivalTime, null);
                System.out.println(busTicket);
                break;
            case 2:
                System.out.println("Enter the travel class");
                String tClass = scanner.nextLine();
                TravelClass travelClass = TravelClass.valueOf(tClass.toUpperCase());

                System.out.println("Enter the carriage number");
                int carriageNumber = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter the seat number");
                int seatNumber = scanner.nextInt();


                TrainTicket trainTicket = new TrainTicket(ref, origin, destination, price,
                        departureTime, arrivalTime,travelClass,carriageNumber,seatNumber);
                System.out.println(trainTicket);
                break;
            case 3:
                System.out.println("Enter the travel class");
                String tClass2 = scanner.nextLine();
                TravelClass travelClass2 = TravelClass.valueOf(tClass2.toUpperCase());

                System.out.println("Enter the number of stopovers");
                int stopovers = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter the seat number");
                int seatNumber2 = scanner.nextInt();

                PlaneTicket planeTicket = new PlaneTicket(ref, origin, destination, price,
                        departureTime, arrivalTime,travelClass2, seatNumber2, stopovers);
                System.out.println(planeTicket);
                break;
        }
    }
}
