package com.example.demo01.repository;

import com.example.demo01.entity.Reservation;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface Repository {
    Reservation findOne(int id);
    boolean save(Reservation reservation);//새글쓰기

    List<Reservation> viewall(); //전체목록 조회

    boolean delete(int id); //삭제후 목록좋


    int modify(int id);

}
/* Reservation modify(int roomnum);*/