package com.dream.cabin.cabin.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Cabin")
public class Cabin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "description")
    private String description;
    @Column(name = "max_capacity")
    private int maxCapacity;

    @Column(name = "regular_price")
    private Double regularPrice;

    @Column(name = "discount")
    private int discount;
    @Column(name = "is_active")
    private boolean isActive;

    public Double getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(Double regularPrice) {
        this.regularPrice = regularPrice;
    }

    @Column(name = "created_at")
    final private Date createdAt;

    @ManyToMany(mappedBy = "cabinSet")
    private Set<Booking> bookingSet = new HashSet<>();

    public Cabin() {
        this.createdAt = new Date();
    }

    public Cabin(int id, String name, String location, String detail,double regularPrice) {
        this.id = id;
        this.name = name;
        this.imageUrl = location;
        this.description = detail;
        this.createdAt = new Date();
        this.regularPrice = regularPrice;
    }

    public int getDiscount() {
        return this.discount;
    }

    public Set<Booking> getBookingSet() {
        return bookingSet;
    }

    public void setBookingSet(Set<Booking> bookingSet) {
        this.bookingSet = bookingSet;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public String toString() {
        return "id :" + this.id + " name: " + this.name;
    }
}
