package com.virtualpairprogrammers.travelbooking.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class PlaneTicket extends TravelTicket {

    private Integer travelClass;
    private Integer seatNumber;
    private Integer stopOvers;

    public PlaneTicket() {
        super();
    }

    public PlaneTicket(Long bookingRef, String origin, String destination, BigDecimal price, LocalDateTime departureTime, LocalDateTime arrivalTime, Integer travelClass, Integer seatNumber, Integer stopOvers) {
        super(bookingRef, origin, destination, price, departureTime, arrivalTime);
        this.travelClass = travelClass;
        this.seatNumber = seatNumber;
        this.stopOvers = stopOvers;
    }

    public Integer getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(Integer travelClass) {
        this.travelClass = travelClass;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getStopOvers() {
        return stopOvers;
    }

    public void setStopOvers(Integer stopOvers) {
        this.stopOvers = stopOvers;
    }

    public void upgrade() {
        super.setPrice(getPrice().multiply(new BigDecimal("2")));
        System.out.println("You have been upgraded");
    }

    public void addStopOver() {
        stopOvers++;
        System.out.println("You have " + stopOvers + " stopovers");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlaneTicket)) return false;
        if (!super.equals(o)) return false;
        PlaneTicket that = (PlaneTicket) o;
        return Objects.equals(travelClass, that.travelClass) && Objects.equals(seatNumber, that.seatNumber) && Objects.equals(stopOvers, that.stopOvers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), travelClass, seatNumber, stopOvers);
    }

    @Override
    public String toString() {
        return "PlaneTicket{" +
                "travelClass=" + travelClass +
                ", seatNumber=" + seatNumber +
                ", stopOvers=" + stopOvers +
                '}';
    }
}
