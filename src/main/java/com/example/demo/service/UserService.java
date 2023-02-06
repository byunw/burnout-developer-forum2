package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UserRepository;
import com.example.demo.domain.User;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

        public String join(String userName,String password){

        User user = userRepository.findByUserName(userName);

        if(user==null){
            User user1 = User.builder()
                    .userName(userName)
                    .password(password)
                    .build();
            userRepository.save(user1);
            return "success";
        }

        else{
            return "invalid";
        }

    }

}
