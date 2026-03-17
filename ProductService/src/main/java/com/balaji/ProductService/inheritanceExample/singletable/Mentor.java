package com.balaji.ProductService.inheritanceExample.singletable;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_mentor")
@DiscriminatorValue("1")
public class Mentor extends User {

    private double avgRating;


}
