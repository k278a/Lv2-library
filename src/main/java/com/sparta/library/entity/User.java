package com.sparta.library.entity;

import com.sparta.library.dto.UserRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //primary key
    private Long id;
    private String username;
    private String gender;
    private String ssn;    //user 주민번호
    private String upn;    //user 전화번호
    private String useradress;

    public User() {  // 기본 생성자 이유

    }

    public User(UserRequestDto userRequestDto) {
        this.username = userRequestDto.getUsername();
        this.gender = userRequestDto.getGender();
        this.ssn = userRequestDto.getssn();
        this.upn = userRequestDto.getupn();
        this.useradress = userRequestDto.getUseradress();
    }

    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getGender() {
        return gender;
    }
    public String getSsn() {
        return ssn;
    }
    public String getUpn() {
        return upn;
    }
    public String getUseradress() {
        return useradress;
    }



}
