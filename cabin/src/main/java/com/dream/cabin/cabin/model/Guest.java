package com.dream.cabin.cabin.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@Table(name = "Guest")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "full_name")
    @Size(min = 2)
    private String fullName;
    @Column(name = "email_address")
    @Email
    private String emailAddress;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "country_flag")
    private String countryFlag;
    @Column(name = "national_id")
    private String nationalId;
    @Column(name = "is_active")
    private boolean isActive;
    @OneToMany(mappedBy = "guest")
    private List<Booking> bookingList;

    Guest() {
        this.createdAt = new Date();
    }


    Guest(long id, String fullName, String emailAddress, String nationality, String countryFlag, String nationalId, boolean isActive) {
        this.id = id;
        this.createdAt = new Date();
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.nationality = nationality;
        this.countryFlag = countryFlag;
        this.nationalId = nationalId;
        this.isActive = isActive;
    }

    public void setActive(final boolean active) {
        this.isActive = active;
    }
    public boolean getIsActive() {
        return isActive;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public void setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setNationality(final String nationality) {
        this.nationality = nationality;
    }

    public void setCountryFlag(final String countryFlag) {
        this.countryFlag = countryFlag;
    }

    public void setNationalId(final String nationalId) {
        this.nationalId = nationalId;
    }

    public long getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getNationality() {
        return nationality;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public String getNationalId() {
        return nationalId;
    }



    @Override
    public String toString() {
        return "id: " + this.id + " full-name: " + this.fullName;
    }

}
