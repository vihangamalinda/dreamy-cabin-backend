package com.dream.cabin.cabin.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CabinDTO {
    private Integer id;

    private String name;

    private String imageUrl;
    private String description;
    private int maxCapacity;
    private int discount;
    private boolean isActive;

    @Override
    public String toString(){
        return  "name: "+this.name+" id:"+this.id;
    }
}
