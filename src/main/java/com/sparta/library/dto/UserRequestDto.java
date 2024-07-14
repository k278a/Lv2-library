package com.sparta.library.dto;

public class UserRequestDto {
    private String username;
    private String gender;  //true - 남자 false - 여자
    private String ssn;
    private String upn;
    private String useradress;

    public UserRequestDto() {

    }


    public UserRequestDto(UserRequestDto userRequestDto) {
        this.username = userRequestDto.getUsername();
        this.gender = userRequestDto.getGender();
        this.ssn = userRequestDto.getssn();
        this.upn = userRequestDto.getupn();
        this.useradress = userRequestDto.getUseradress();
    }

    public String getUsername(){
        return username;
    }
    public String getGender(){
        return gender;
    }
    public String getssn(){
        return ssn;
    }
    public String getupn(){
        return upn;
    }
    public String getUseradress(){
        return useradress;
    }
}
