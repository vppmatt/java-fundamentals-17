package com.virtualpairprogrammers.travelbooking.bookingProcess;

import com.virtualpairprogrammers.travelbooking.domain.TravelTicket;

public class CheapTravelBookingSystem implements BookingSystem {

    @Override
    public void setTravelTicket(TravelTicket ticket) {
        System.out.println("CheapTravel has recieved ticket " + ticket);
    }

    @Override
    public void requestBooking() {
        System.out.println("Cheap travel has had a booking request");
    }

    @Override
    public boolean getStatus() {
        return false;
    }

    @Override
    public boolean cancel() {
        return false;
    }
}
