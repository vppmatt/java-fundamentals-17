package com.virtualpairprogrammers.travelbooking.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class TravelTicket {

    private Long bookingRef;
    private String origin;
    private String destination;
    private BigDecimal price;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    public TravelTicket() {}

    public TravelTicket(Long bookingRef, String origin, String destination, BigDecimal price, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.bookingRef = bookingRef;
        this.origin = origin;
        this.destination = destination;
        this.price = price;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Long getBookingRef() {
        return bookingRef;
    }

    protected void setBookingRef(Long bookingRef) {
        this.bookingRef = bookingRef;
    }

    public String getOrigin() {
        return origin;
    }

    protected void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    protected void setDestination(String destination) {
        this.destination = destination;
    }

    public BigDecimal getPrice() {
        return price;
    }

    protected void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    protected void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    protected void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void reschedule() {
        System.out.println("I am rescheduling the ticket");
    }

    public void cancel() {
        System.out.println("I am cancelling the ticket");
    }
}
