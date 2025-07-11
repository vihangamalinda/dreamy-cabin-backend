package com.dream.cabin.cabin.model;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.Date;
import java.util.Set;

@Entity
@Builder
@Table(name = "Booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "num_of_nights")
    private int numNights;
    @Column(name = "num_of_guests")
    private int numGuests;
    @Column(name = "cabin_price")
    private double cabinPrice;
    @Column(name = "extra_price")
    private double extraPrice;
    @Column(name = "total_price")
    private double totalPrice;
    @Column(name = "status")
    private String status;
    @Column(name = "has_Breakfast")
    private boolean hasBreakfast;
    @Column(name = "is_paid")
    private boolean isPaid;
    @Column(name = "observations")
    private String observations;
    @Column(name = "is_active")
    private boolean isActive;

    //   FKs
//    booked by which employee
//    cabin id
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Booked_Cabin",
            joinColumns = {@JoinColumn(name = "booking_id")},
            inverseJoinColumns = {@JoinColumn(name = "cabin_id")}
    )
    private Set<Cabin> cabinSet;
    //    guest id
    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Booking() {
        this.createdAt = new Date();
        this.isActive =true;
    }

    public Booking(long id, Date startDate, Date endDate, int numNights, int numGuests, double cabinPrice, double extraPrice, double totalPrice, String status, boolean hasBreakfast, boolean isPaid, String observations, boolean isActive, Guest guest, Set<Cabin> cabinSet) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numNights = numNights;
        this.numGuests = numGuests;
        this.cabinPrice = cabinPrice;
        this.extraPrice = extraPrice;
        this.totalPrice = totalPrice;
        this.status = status;
        this.hasBreakfast = hasBreakfast;
        this.isPaid = isPaid;
        this.observations = observations;
        this.isActive = true;
        this.cabinSet = cabinSet;
        this.guest = guest;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getNumNights() {
        return numNights;
    }

    public void setNumNights(int numNights) {
        this.numNights = numNights;
    }

    public int getNumGuests() {
        return numGuests;
    }

    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
    }

    public double getCabinPrice() {
        return cabinPrice;
    }

    public void setCabinPrice(double cabinPrice) {
        this.cabinPrice = cabinPrice;
    }

    public double getExtraPrice() {
        return extraPrice;
    }

    public void setExtraPrice(double extraPrice) {
        this.extraPrice = extraPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isHasBreakfast() {
        return hasBreakfast;
    }

    public void setHasBreakfast(boolean hasBreakfast) {
        this.hasBreakfast = hasBreakfast;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public String toString() {
        return "booking-id: "+this.id;
    }
}
