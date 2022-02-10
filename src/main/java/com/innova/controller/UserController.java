package com.innova.controller;

import com.innova.dto.UserLoginDto;
import com.innova.dto.UserRegisterDto;
import com.innova.entity.UserRegisterEntity;
import com.innova.repository.IUserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@Log4j2
public class UserController {

    @Autowired
    IUserRepository iUserRepository;

    //REGISTER
    // http://localhost:8080/register
    @GetMapping("/register")
    public String getRegisterForm(Model model){
        model.addAttribute("register_key", new UserRegisterDto());
        return "registerpage";
    }

    // http://localhost:8080/register
    @PostMapping("/register")
    public String postRegisterForm(@Valid @ModelAttribute("register_key") UserRegisterDto userRegisterDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("Hata Oluştu");
            log.info(userRegisterDto);
            return "registerpage";
        }else{
            UserRegisterEntity userRegisterEntity = UserRegisterEntity.builder()
                    .userId(0L)
                    .userEmail(userRegisterDto.getUserEmail())
                    .userPassword(userRegisterDto.getUserPassword())
                    .build();

            iUserRepository.save(userRegisterEntity);
            return "success";
        }
    }

    //LOGIN
    // http://localhost:8080/login
    @GetMapping("/login")
    public String getLoginForm(Model model){
        model.addAttribute("login_key", new UserLoginDto());
        return "formvalidation2";
    }

    // http://localhost:8080/login
    @PostMapping("/login")
    public String postRegisterForm(@Valid @ModelAttribute("login_key") UserLoginDto userLoginDto, BindingResult bindingResult
    ){
        if(bindingResult.hasErrors()){
            log.error("Login islemi sırasında hata Oluştu");
            log.info(userLoginDto);
            return "formvalidation2";
        }else{
            //Kontrol yapacagım
            log.info(userLoginDto);
            return "success";
        }
    }
}
