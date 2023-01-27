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

    Reservation delete(int id);


}
