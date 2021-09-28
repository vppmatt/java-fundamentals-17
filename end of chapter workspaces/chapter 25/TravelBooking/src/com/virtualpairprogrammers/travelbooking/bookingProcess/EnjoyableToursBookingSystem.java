package com.virtualpairprogrammers.travelbooking.bookingProcess;

import com.virtualpairprogrammers.travelbooking.domain.TravelTicket;

public class EnjoyableToursBookingSystem implements BookingSystem {
    @Override
    public void setTravelTicket(TravelTicket ticket) {
        System.out.println("Enjoyable Tours has received ticket " + ticket);
    }

    @Override
    public void requestBooking() {
        System.out.println("Enjoyable Tours has received a booking request ");
    }

    @Override
    public boolean getStatus() {
        System.out.println("Enjoyable Tours has is providing the booking status");
        return false;
    }

    @Override
    public boolean cancel() {
        return false;
    }


}
