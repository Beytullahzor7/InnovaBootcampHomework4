package com.innova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class UserLoginDto {

    @NotEmpty(message = "Email alanı bos gecilemez")
    @Email(message = "Uygun formatta bir email giriniz")
    private String userEmail;

    @NotEmpty(message = "Password alanı bos gecilemez")
    @Size(min = 5, max = 15)
    private String userPassword;
}
