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

            List<Reservation> reservations = service.deleteServ(id);
            if(reservations==null){
                log.info("실패");
                return ResponseEntity.notFound().build();
            }else {
                return ResponseEntity.ok().body(reservations);
            }
        }catch (Exception e){
            return ResponseEntity.ok().body(e.getMessage());
        }// try-catch
    }//delete end


    @PutMapping("/{id}")//방번호 수정
    public ResponseEntity<?> update(@RequestBody Reservation reservation,@PathVariable int id){
        log.info("{} 방번호 수정 스타트", id);

        try {
            int roomupdate = service.roomupdate(id);
            return  ResponseEntity.ok().body(roomupdate);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }//try-catch
    } //방 수정 완료*/

} //class end


