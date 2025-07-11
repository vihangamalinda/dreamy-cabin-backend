package com.dream.cabin.cabin.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Setting")
@Builder
public class Setting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "min_booking_length")
    private int minBookingLength;
    @Column(name = "max_booking_length")
    private int maxBookingLength;
    @Column(name = "max_guest_per_booking")
    private int maxGuestPerBooking;
    @Column(name = "breakfast_price")
    private double breakfastPrice;

    Setting() {
        this.createdAt = new Date();
    }

    Setting(long id, int minBookingLength, int maxBookingLength, int maxGuestPerBooking, double breakfastPrice) {
        this.id = id;
        this.minBookingLength = minBookingLength;
        this.maxBookingLength = maxBookingLength;
        this.maxGuestPerBooking = maxGuestPerBooking;
        this.breakfastPrice = breakfastPrice;
        this.createdAt = new Date();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getMinBookingLength() {
        return minBookingLength;
    }

    public void setMinBookingLength(int minBookingLength) {
        this.minBookingLength = minBookingLength;
    }

    public int getMaxBookingLength() {
        return maxBookingLength;
    }

    public void setMaxBookingLength(int maxBookingLength) {
        this.maxBookingLength = maxBookingLength;
    }

    public int getMaxGuestPerBooking() {
        return maxGuestPerBooking;
    }

    public void setMaxGuestPerBooking(int maxGuestPerBooking) {
        this.maxGuestPerBooking = maxGuestPerBooking;
    }

    public double getBreakfastPrice() {
        return breakfastPrice;
    }

    public void setBreakfastPrice(double breakfastPrice) {
        this.breakfastPrice = breakfastPrice;
    }

    @Override
    public String toString() {
        return "id: " + this.id + " created_at: " + this.createdAt + " min_booking_length: " + this.minBookingLength + " max_booking_length:" + this.maxBookingLength + " max_guest_per_booking: " + this.maxGuestPerBooking + " breakfast_price: " + this.breakfastPrice;
    }
}
