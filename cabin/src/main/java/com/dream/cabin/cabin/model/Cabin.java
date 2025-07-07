package com.dream.cabin.cabin.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Cabin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    @Column(name="name")
    private String name;

    @Column(name="image_url")
    private String imageUrl;
    @Column(name="description")
    private String description;
    @Column(name = "max_capacity")
    private int maxCapacity;
    @Column(name="discount")
    private int discount;
    @Column(name = "is_active")
    private boolean isActive;


    @Column(name="created_at")
    final private Date createdAt;

    public Cabin(){
        this.createdAt =new Date();
    }
    public Cabin(int id,String name,String location,String detail){
        this.id =id;
        this.name=name;
        this.imageUrl=location;
        this.description =detail;
        this.createdAt = new Date();
    }

    public int getDiscount(){
        return this.discount;
    }
    public void setDiscount(int discount){
        this.discount =discount;
    }
    public int getMaxCapacity(){
        return  this.maxCapacity;
    }
    public void setMaxCapacity(int maxCapacity){
        this.maxCapacity =maxCapacity;
    }
    public boolean getIsActive(){
        return  this.isActive;
    }

    public void setIsActive(boolean isActive){
        this.isActive =isActive;
    }
    public int getId(){
        return  this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name =name;
    }
    public String getImageUrl(){
        return this.imageUrl;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl =imageUrl;
    }
    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Date getCreatedAt(){
        return  this.createdAt;
    }

    @Override
    public String toString(){
        return "id :"+this.id+" name: "+ this.name;
    }
}
