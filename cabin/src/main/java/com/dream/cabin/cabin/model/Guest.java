package com.dream.cabin.cabin.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "country_flag")
    private String countryFlag;
    @Column(name = "national_id")
    private String nationalId;
    @Column(name = "is_active")
    private boolean isActive;

    @Override
    public String toString() {
        return "id: " + this.id + " full-name: " + this.fullName;
    }

}
