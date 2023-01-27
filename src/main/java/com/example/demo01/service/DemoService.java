package com.example.demo01.service;

import com.example.demo01.entity.Reservation;
import com.example.demo01.repository.Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DemoService {
    @Autowired
    private final Repository repository;


    public Reservation finOneServ(int id){
        Reservation reservation = repository.findOne(id);
        log.info("findOneServ return data - {}", id);
        return reservation;
    }


    public Reservation createServ(final Reservation reservation){
        if (reservation==null) {
            log.warn("newTodo cannot be null!");
            throw new RuntimeException("newTodo cannot be null!");
        }
        boolean flag =repository.save(reservation);

        return reservation;
    }

    //전체항목 부르기
    public List<Reservation> viewall(){
        log.info("전체목록 진입 성공");
        List<Reservation> viewall = repository.viewall();
        return  viewall;
    }

    //삭제하기
    public Reservation deleteServ(int id){
        log.info("삭제 service 진향");
        Reservation reservation=repository.delete(id);
        return reservation;
    }//delete end
}
