package com.example.demo01.api;

import com.example.demo01.entity.Reservation;
import com.example.demo01.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/demo")
@RequiredArgsConstructor
@CrossOrigin
public class DemoApi {


    private final DemoService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable int id) {
        log.info("동작 {}", id);

        Reservation reservation = service.finOneServ(id);
        return ResponseEntity.ok().body(reservation);

    }
    @PostMapping //새글등록
    public ResponseEntity<?> create(@RequestBody Reservation reservation){
       log.info("/api/todos POST request! - {}", reservation.getName());
       try {
           Reservation reservation1=service.createServ(reservation);
           if (reservation1==null){
               return ResponseEntity.notFound().build();
           }else {
               return ResponseEntity.ok().body(reservation1);
           }
       }catch (RuntimeException e){
           return ResponseEntity.badRequest().body(e.getMessage());
       }

    }

    @GetMapping //전체항목 불러오기
    public ResponseEntity<?> listAll(){
        log.info("전체항목 불러오기");
        List<Reservation> viewall = service.viewall();
        return ResponseEntity.ok().body(viewall);
    }


    @DeleteMapping("/{id}") //삭제요청
    public ResponseEntity<?> delete(@PathVariable int id){
        log.info("목록 삭제 기능 스타트");
        try {
            Reservation reservation =service.deleteServ(id);
            if(reservation==null){
                log.info("error");
                return ResponseEntity.notFound().build();
            }else {
                return ResponseEntity.ok().body(reservation);
            }
        }catch (Exception e){
            return ResponseEntity.ok().body(id);
        }// try-catch
    }//delete end


} //class end
