package com.example.demo01.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import java.util.Date;


@Getter
@Setter
public class Reservation {
    private int id;
    private String name;
    private Date reservedate;
    private int roomnum;

    public void enroll(int id, String name, Date reservedate, int roomnum){
        this.id=id;
        this.name=name;
        this.reservedate=reservedate;
        this.roomnum=roomnum;
    }


}
