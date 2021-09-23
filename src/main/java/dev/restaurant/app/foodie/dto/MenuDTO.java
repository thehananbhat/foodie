package dev.restaurant.app.foodie.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class MenuDTO {

    private String dish;
    private int price;
    private Date date;
}
