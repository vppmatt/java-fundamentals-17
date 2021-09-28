package com.virtualpairprogrammers.travelbooking.domain;

import com.virtualpairprogrammers.travelbooking.exceptions.InvalidTravelDurationException;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class BusTicket extends TravelTicket {

    private ArrayList<String> permittedProviders;

    public BusTicket() {
        super();
    }

    public BusTicket(Long bookingRef, String origin, String destination, BigDecimal price, LocalDateTime departureTime, LocalDateTime arrivalTime, ArrayList<String> permittedProviders) throws InvalidTravelDurationException {
        super(bookingRef, origin, destination, price, departureTime, arrivalTime);
        this.permittedProviders = permittedProviders;
    }

    public BusTicket(TravelTicket t, ArrayList<String> permittedProviders) throws InvalidTravelDurationException {
        super(t.getBookingRef(), t.getOrigin(), t.getDestination(), t.getPrice(), t.getDepartureTime(), t.getArrivalTime());
        this.permittedProviders = permittedProviders;
    }

    public ArrayList<String> getPermittedProviders() {
        return permittedProviders;
    }

    public void setPermittedProviders(ArrayList<String> permittedProviders) {
        this.permittedProviders = permittedProviders;
    }

    @Override
    public void cancel() {
        Duration d = Duration.between(LocalDateTime.now(), getDepartureTime());
        Long days = d.toDays();
        if (days > 30) {
            super.cancel();
        }
        else {
            System.out.println("Sorry you cannot cancel within 30 days");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusTicket)) return false;
        if (!super.equals(o)) return false;
        BusTicket busTicket = (BusTicket) o;
        return Objects.equals(permittedProviders, busTicket.permittedProviders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), permittedProviders);
    }

    @Override
    public String toString() {
        return "BusTicket{" +
                super.toString() +
                " permittedProviders=" + permittedProviders +
                "} " ;
    }
}
