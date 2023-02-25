package com.example.demo.controller;

import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import com.example.demo.domain.dto.UserJoinRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRegisterController {

     private final UserService userService;

     @PostMapping(value = "/register")
     public ResponseEntity<String> registerUser(@RequestBody UserJoinRequest dto){
          String result = userService.join(dto.getUserName(),dto.getPassword());

          if(result=="success"){
               return ResponseEntity.ok().body("회원가입이 성공 했습니다!");
          }

          else{
               return new ResponseEntity<>("중복아이디여서 회원가입이 실패했습니다. 다른 아이디를 입력해주세요!",HttpStatus.CONFLICT);
          }
          
     }

}
