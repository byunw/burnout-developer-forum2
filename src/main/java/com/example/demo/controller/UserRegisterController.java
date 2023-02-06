package com.example.demo.controller;

import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import com.example.demo.domain.dto.UserJoinRequest;
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

     //회원 가입 API
     @PostMapping(value = "/register")
     public ResponseEntity<String> registerUser(@RequestBody UserJoinRequest dto){
          String result = userService.join(dto.getUserName(),dto.getPassword());
          return result=="success" ? ResponseEntity.ok().body("회원가입이 성공 했습니다!") : ResponseEntity.ok().body("회원가입이 실패했습니다");
     }

}
